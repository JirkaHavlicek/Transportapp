package com.example.customers_module.service;


import com.example.customers_module.dto.OrderDTO;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface OrderService {

    OrderDTO addOrder(OrderDTO orderDTO);

    List<OrderDTO> getAllOrders();

    OrderDTO editOrder(OrderDTO orderDTO, long id);

    OrderDTO removeOrder(Long id);

    OrderDTO getOrder(Long id);

}
