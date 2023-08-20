package com.example.customers_module.service;


import com.example.customers_module.dto.OrderDTO;
import com.example.customers_module.dto.mapper.OrderMapper;
import com.example.customers_module.entity.OrderEntity;
import com.example.customers_module.entity.filter.OrderFilter;
import com.example.customers_module.entity.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;


    @Autowired
    private OrderMapper orderMapper;

    public OrderDTO addOrder(OrderDTO orderDTO){
        OrderEntity order = orderMapper.toEntity(orderDTO);
        mapCustomerToOrder(order, orderDTO);
        OrderEntity saved = orderRepository.save(order);
        return orderMapper.toDTO(saved);
    }

    public List<OrderDTO> getAllorders(OrderFilter orderFilter){
        OrderSpecification orderSpecification = new OrderSpecification(orderFilter);

        return orderRepository.findAll(orderSpecification, PageRequest.of(0, orderFilter.getLimit()))
                .stream()
                .map(orderMapper::toDTO)
                .collect(Collectors.toList());
    }

    public OrderDTO editOrder(OrderDTO orderDTO, long id){
        orderDTO.setId(id);
        OrderEntity entity = orderRepository.getReferenceById(id);
        orderMapper.updateEntity(orderDTO, entity);

        return orderMapper.toDTO(saved);
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
}
