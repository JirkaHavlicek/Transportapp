package com.example.customers_module.service;

import com.example.customers_module.dto.CustomerDTO;
import com.example.customers_module.entity.CustomerEntity;
import com.example.customers_module.entity.repository.CustomerRepository;
import com.example.customers_module.service.exceptions.DuplicateEmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public CustomerDTO create(CustomerDTO model) {
        try {
            CustomerEntity entity = new CustomerEntity();
            entity.setEmail(model.getEmail());
            entity.setPassword(passwordEncoder.encode(model.getPassword()));

            entity = userRepository.save(entity);

            CustomerDTO dto = new CustomerDTO();
            dto.setUserId(entity.getCustomerId());
            dto.setEmail(entity.getEmail());
            return dto;
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateEmailException();
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username, " + username + " not found"));
    }
}
