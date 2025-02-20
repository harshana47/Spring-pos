const API_URL = "http://localhost:8080/10_BackEnd_Web_exploded/api/v1/customer";
let imageData = "";

$(document).ready(function () {
    loadCustomers();
});

function loadCustomers() {
    $.ajax({
        url: `${API_URL}/getAll`,
        type: "GET",
        success: function (customers) {
            $("#customerTableBody").empty();
            customers.forEach(customer => {
                let newRow = `<tr onclick="selectRow(this)">
                        <td>${customer.id}</td>
                        <td>${customer.name}</td>
                        <td>${customer.address}</td>
                        <td><img src="${customer.image}" class="img-thumbnail" style="max-width: 100px;"></td>
                        <td><button class="btn btn-sm btn-danger" onclick="deleteCustomer('${customer.id}', this)">Delete</button></td>
                      </tr>`;
                $("#customerTableBody").append(newRow);
            });
        },
        error: function () {
            alert("Error loading customers!");
        }
    });
}

function saveData() {
    let customer = {
        id: $("#customerId").val(),
        name: $("#customerName").val(),
        address: $("#customerAddress").val(),
        image: imageData
    };

    $.ajax({
        url: `${API_URL}/save`,
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(customer),
        success: function () {
            alert("Customer saved successfully!");
            loadCustomers();
            clearForm();
        },
        error: function () {
            alert("Error saving customer!");
        }
    });
}

function updateData() {
    if (!selectedRow) {
        alert("Please select a row to update!");
        return;
    }

    let customer = {
        id: $("#customerId").val(),
        name: $("#customerName").val(),
        address: $("#customerAddress").val(),
        image: imageData
    };

    $.ajax({
        url: `${API_URL}/update`,
        type: "PUT",
        contentType: "application/json",
        data: JSON.stringify(customer),
        success: function () {
            alert("Customer updated successfully!");
            loadCustomers();
            clearForm();
        },
        error: function () {
            alert("Error updating customer!");
        }
    });
}

// Function to delete a customer
function deleteCustomer(id, button) {
    $.ajax({
        url: `${API_URL}/delete/${id}`,
        type: "DELETE",
        success: function () {
            alert("Customer deleted successfully!");
            $(button).closest("tr").remove();
        },
        error: function () {
            alert("Error deleting customer!");
        }
    });
}

function selectRow(row) {
    selectedRow = row;
    $("#customerId").val($(row).find("td:eq(0)").text());
    $("#customerName").val($(row).find("td:eq(1)").text());
    $("#customerAddress").val($(row).find("td:eq(2)").text());
    let imgSrc = $(row).find("td:eq(3) img").attr("src");
    if (imgSrc) {
        $("#imagePreview").attr("src", imgSrc).show();
        imageData = imgSrc;
    }
}

function previewImage(event) {
    const file = event.target.files[0];
    if (file) {
        const reader = new FileReader();
        reader.onload = function(e) {
            $("#imagePreview").attr("src", e.target.result).show();
            imageData = e.target.result;
        };
        reader.readAsDataURL(file);
    }
}
$(document).ready(function (){
    loadCustomers();
})

function clearForm() {
    $("#customerId").val("");
    $("#customerName").val("");
    $("#customerAddress").val("");
    $("#customerImage").val("");
    $("#imagePreview").attr("src", "").hide();
    imageData = "";
    selectedRow = null;
}