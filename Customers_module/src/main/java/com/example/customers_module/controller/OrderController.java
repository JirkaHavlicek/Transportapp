package com.example.customers_module.controller;


import com.example.customers_module.dto.OrderDTO;
import com.example.customers_module.entity.CustomerEntity;
import com.example.customers_module.entity.OrderEntity;
import com.example.customers_module.entity.filter.OrderFilter;
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


    @Secured("ROLE_ADMIN")
    @PostMapping("/add")
    public OrderDTO addOrder(@RequestBody OrderDTO orderDTO){
        return orderService.addOrder(orderDTO);
    }

    @GetMapping("/all")
    public List<OrderDTO> getAllOrders(OrderFilter orderFilter){
        return orderService.getAllOrders(orderFilter);
    }

    @GetMapping("/{id}")
    public OrderDTO getOrder(@PathVariable Long id) {
        return orderService.getOrder(id);
    }

    @Secured("ROLE_ADMIN")
    @PutMapping("/{id}")
    public OrderDTO editOrder(@RequestBody OrderDTO orderDTO, @PathVariable long id){
        return orderService.editOrder(orderDTO, id);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/{id}")
    public void removeOrder(@PathVariable Long id){
        orderService.removeOrder(id);
    }
}

