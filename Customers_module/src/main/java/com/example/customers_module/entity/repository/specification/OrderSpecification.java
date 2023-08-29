package com.example.customers_module.entity.repository.specification;

import com.example.customers_module.entity.*;
import com.example.customers_module.entity.OrderEntity;
import com.example.customers_module.entity.CustomerEntity;
import com.example.customers_module.entity.filter.OrderFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;



@RequiredArgsConstructor
public class OrderSpecification implements Specification<OrderEntity> {

    private final OrderFilter filter;


    @Override
    public Predicate toPredicate(Root<OrderEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (filter.getOrderID() != null) {
            predicates.add(criteriaBuilder.equal(root.get(OrderEntity_.ID), filter.getOrderID()));
        }

        if (filter.getCustomerID() != null) {
            Join<OrderEntity, CustomerEntity> customerJoin = root.join(OrderEntity_.customer);
            predicates.add(criteriaBuilder.equal(customerJoin.get(CustomerEntity_.CUSTOMER_ID), filter.getCustomerID()));
        }

        if (filter.getEmail() != null) {
            Join<OrderEntity, CustomerEntity> customerJoin = root.join(OrderEntity_.customer);
            predicates.add(criteriaBuilder.equal(customerJoin.get(CustomerEntity_.email), filter.getEmail()));
        }


        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}