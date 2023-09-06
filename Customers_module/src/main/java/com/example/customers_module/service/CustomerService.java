package com.example.customers_module.service;

import com.example.customers_module.dto.CustomerDTO;
import com.example.customers_module.dto.CustomersOrderDTO;
import org.springframework.security.core.userdetails.UserDetailsService;



public interface CustomerService extends UserDetailsService {

    CustomerDTO create(CustomerDTO model);

    CustomersOrderDTO getCustomer(Long customerId);


}
