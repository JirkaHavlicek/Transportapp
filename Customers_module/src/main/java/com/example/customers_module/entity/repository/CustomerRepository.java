package com.example.customers_module.entity.repository;

import com.example.customers_module.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    Optional<CustomerEntity> findByEmail(String username);


}

