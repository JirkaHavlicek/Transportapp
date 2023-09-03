package com.example.customers_module.service;

import com.example.customers_module.dto.CustomerDTO;
import org.springframework.security.core.userdetails.UserDetailsService;



public interface CustomerService extends UserDetailsService {

    CustomerDTO create(CustomerDTO model);

    CustomerDTO getCustomer(Long customerId);


}
