package com.example.customers_module.dto.mapper;

import com.example.customers_module.dto.OrderDTO;
import com.example.customers_module.entity.CustomerEntity;
import com.example.customers_module.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "customers", ignore = true)
    OrderEntity toEntity(OrderDTO source);

    @Mapping(target = "customerIDs", source = "customers.id")
    OrderDTO toDTO(OrderEntity source);

    @Mapping(target = "customers", ignore = true)
    void updateEntity(OrderDTO source, @MappingTarget OrderEntity target);


}


