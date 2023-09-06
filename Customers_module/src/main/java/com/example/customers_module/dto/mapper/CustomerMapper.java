package com.example.customers_module.dto.mapper;

import com.example.customers_module.dto.CustomerDTO;
import com.example.customers_module.dto.CustomersOrderDTO;
import com.example.customers_module.dto.OrderDTO;
import com.example.customers_module.entity.CustomerEntity;
import com.example.customers_module.entity.OrderEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerEntity toCustomer(CustomersOrderDTO source);

    CustomersOrderDTO toDTO(CustomerEntity source);

}
