package com.example.customers_module.service;


import com.example.customers_module.dto.OrderDTO;
import com.example.customers_module.entity.filter.OrderFilter;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface OrderService {

    OrderDTO addOrder(OrderDTO movieDTO);

    List<OrderDTO> getAllMOrders(OrderFilter movieFilter);

    OrderDTO editOrder(OrderDTO movieDTO, long id);

    OrderDTO removeOrder(Long id);

    OrderDTO getOrder(Long id);

}
