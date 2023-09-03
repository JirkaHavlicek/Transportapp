package com.example.customers_module.service;

import com.example.customers_module.dto.mapper.CustomerMapper;
import com.example.customers_module.dto.CustomerDTO;
import com.example.customers_module.dto.mapper.CustomerMapper;
import com.example.customers_module.entity.CustomerEntity;
import com.example.customers_module.entity.repository.CustomerRepository;
import com.example.customers_module.service.exceptions.DuplicateEmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomerMapper customerMapper;


    @Override
    public CustomerDTO create(CustomerDTO model) {
        try {
            CustomerEntity entity = new CustomerEntity();
            entity.setEmail(model.getEmail());
            entity.setPassword(passwordEncoder.encode(model.getPassword()));

            entity = customerRepository.save(entity);

            CustomerDTO dto = new CustomerDTO();
            dto.setId(entity.getId());
            dto.setEmail(entity.getEmail());
            return dto;
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateEmailException();
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return customerRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username, " + username + " not found"));
    }
    public CustomerDTO getCustomer(Long customerId) {
        CustomerEntity customer = customerRepository.getReferenceById(customerId);
        return customerMapper.toDTO(customer);
    }
}
