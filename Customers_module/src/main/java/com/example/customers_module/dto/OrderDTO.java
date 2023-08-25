package com.example.customers_module.dto;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;



@Data
public class OrderDTO {


    @JsonProperty("_id")
    private Long orderId;
    private String transportPayer;

    private LocalDateTime loadingDate;
    private String loadingAddress;
    private String loadingContactPerson;
    private String loadingContactPhone;

    private int accountNumber;
    private int variableSymbol;
    private int cashOnDelivery;

    private int itemCount;
    private int packaging;
    private double totalWeight;

    private String contentDescription;
    private double packageValue;

    private int length;
    private int width;
    private int height;

    private String recipientName;
    private String recipientStreet;
    private int recipientHouseNumber;
    private String recipientCity;
    private String recipientPostalCode;
    private String recipientPhoneNumber;
    private String recipientEmail;

    private String note;

    private CustomerDTO customerId;
}
