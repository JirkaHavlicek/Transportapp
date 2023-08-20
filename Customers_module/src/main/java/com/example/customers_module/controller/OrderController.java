package com.example.customers_module.controller;


import com.example.customers_module.entity.CustomerEntity;
import com.example.customers_module.entity.OrderEntity;
import com.example.customers_module.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;



    @GetMapping("/{customerId}")
    public ResponseEntity<List<OrderEntity>> getOrdersForCustomer(@PathVariable Long customerId) {
        // Fetch the customer based on customerId, then retrieve their orders
        CustomerEntity customer = ... // Fetch customer from service/repository
        List<OrderEntity> orders = orderService.getOrdersForCustomer(customer);
        return ResponseEntity.ok(orders);
    }

    @PostMapping("/{customerId}")
    public ResponseEntity<OrderEntity> createOrder(@PathVariable Long customerId) {
        // Fetch the customer based on customerId, then create an order for them
        CustomerEntity customer = ... // Fetch customer from service/repository
        OrderEntity createdOrder = orderService.createOrder(customer);
        return ResponseEntity.ok(createdOrder);
    }
}

