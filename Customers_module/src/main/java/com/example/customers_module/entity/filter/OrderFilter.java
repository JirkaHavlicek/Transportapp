package com.example.customers_module.entity.filter;

import lombok.Data;
@Data
public class OrderFilter {
    private Integer orderID;
    private Integer customerID;
    private String email;
    private Integer limit = 10;

}
