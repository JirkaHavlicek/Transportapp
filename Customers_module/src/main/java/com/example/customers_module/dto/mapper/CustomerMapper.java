package com.example.customers_module.dto.mapper;

import com.example.customers_module.dto.CustomerDTO;
import com.example.customers_module.entity.CustomerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerEntity toCustomer(CustomerDTO source);

    CustomerDTO toDTO(CustomerEntity source);

}
