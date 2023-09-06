package com.example.customers_module.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class CustomersOrderDTO {
    @JsonProperty("_id")
    private long id;

    @Email
    private String email;
}
