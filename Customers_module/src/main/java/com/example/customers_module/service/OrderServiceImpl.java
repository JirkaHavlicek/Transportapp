package com.example.customers_module.service;

import com.example.customers_module.entity.CustomerEntity;
import com.example.customers_module.entity.repository.CustomerRepository;
import com.example.customers_module.dto.OrderDTO;
import com.example.customers_module.dto.mapper.OrderMapper;
import com.example.customers_module.entity.OrderEntity;
import com.example.customers_module.entity.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderMapper orderMapper;

    public OrderDTO addOrder(OrderDTO orderDTO){
        OrderEntity order = orderMapper.toEntity(orderDTO);
        mapCustomerToOrder(order, orderDTO);
        OrderEntity saved = orderRepository.save(order);
        return orderMapper.toDTO(saved);
    }

    public List<OrderDTO> getAllOrders(){
       return orderRepository.findAll()
               .stream()
               .map(orderMapper::toDTO)
               .collect(Collectors.toList());
    }

    public OrderDTO editOrder(OrderDTO orderDTO, long id){
        orderDTO.setOrderId(id);
        OrderEntity entity = orderRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        orderMapper.updateEntity(orderDTO, entity);

        mapCustomerToOrder(entity, orderDTO);
        OrderEntity saved = orderRepository.save(entity);
        return orderMapper.toDTO(saved);
    }

    private void mapCustomerToOrder(OrderEntity order, OrderDTO orderDTO){
        CustomerEntity customer = customerRepository.findById(orderDTO.getCustomerID())
                .orElseThrow(EntityNotFoundException::new);
        order.setCustomer(customer);
    }

    public OrderDTO removeOrder(Long id){
        OrderEntity movie = orderRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        OrderDTO model = orderMapper.toDTO(movie);

        orderRepository.delete(movie);
        return model;
    }

    public OrderDTO getOrder(Long id) {
        OrderEntity movie = orderRepository.getReferenceById(id);
        return orderMapper.toDTO(movie);
    }
}
