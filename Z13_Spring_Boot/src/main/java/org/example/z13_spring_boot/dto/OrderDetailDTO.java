package org.example.z13_spring_boot.dto;

public class OrderDetailDTO {

    private int quantity;
    private double total;
    private int itemId;
    private String itemName;
    private double itemPrice;

    // Constructors
    public OrderDetailDTO() {
    }

    public OrderDetailDTO(int quantity, double total, int itemId, String itemName, double itemPrice) {
        this.quantity = quantity;
        this.total = total;
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    // Getters and Setters
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
}
