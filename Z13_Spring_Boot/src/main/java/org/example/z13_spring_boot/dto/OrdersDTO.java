package org.example.z13_spring_boot.dto;

import java.time.LocalDate;
import java.util.List;

public class OrdersDTO {

    private int id;
    private LocalDate orderDate;
    private double totalAmount;
    private int customerId;
    private String customerName;
    private List<OrderDetailDTO> orderDetails;

    // Constructors
    public OrdersDTO() {
    }

    public OrdersDTO(int id, LocalDate orderDate, double totalAmount, int customerId, String customerName, List<OrderDetailDTO> orderDetails) {
        this.id = id;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.customerId = customerId;
        this.customerName = customerName;
        this.orderDetails = orderDetails;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<OrderDetailDTO> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetailDTO> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
