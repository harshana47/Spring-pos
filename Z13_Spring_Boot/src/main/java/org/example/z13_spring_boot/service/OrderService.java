package org.example.z13_spring_boot.service;

import org.example.z13_spring_boot.dto.OrderDetailDTO;
import org.example.z13_spring_boot.dto.OrdersDTO;
import org.example.z13_spring_boot.entity.Customer;
import org.example.z13_spring_boot.entity.Item;
import org.example.z13_spring_boot.entity.OrderDetails;
import org.example.z13_spring_boot.entity.Orders;
import org.example.z13_spring_boot.repo.CustomerRepo;
import org.example.z13_spring_boot.repo.ItemRepo;
import org.example.z13_spring_boot.repo.OrderDetailRepo;
import org.example.z13_spring_boot.repo.OrdersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrdersRepo ordersRepo;

    @Autowired
    private OrderDetailRepo orderDetailRepo;

    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private ItemRepo itemRepo;

    @Transactional
    public boolean addOrder(OrdersDTO ordersDTO) {
        try {
            Customer customer = customerRepo.findById(ordersDTO.getCustomerId())
                    .orElseThrow(() -> new RuntimeException("Customer not found"));

            Orders order = new Orders();
            order.setOrderDate(ordersDTO.getOrderDate());
            order.setTotalAmount(ordersDTO.getTotalAmount());
            order.setCustomer(customer);

            Orders savedOrder = ordersRepo.save(order);

            // Process each order detail
            for (OrderDetailDTO orderDetailDTO : ordersDTO.getOrderDetails()) {
                Item item = itemRepo.findById(orderDetailDTO.getItemId())
                        .orElseThrow(() -> new RuntimeException("Item not found"));

                OrderDetails orderDetails = new OrderDetails();
                orderDetails.setQuantity(orderDetailDTO.getQuantity());
                orderDetails.setTotal(orderDetailDTO.getTotal());
                orderDetails.setItem(item);  // Set the item from the itemId
                orderDetails.setOrders(savedOrder);

                orderDetailRepo.save(orderDetails);
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
