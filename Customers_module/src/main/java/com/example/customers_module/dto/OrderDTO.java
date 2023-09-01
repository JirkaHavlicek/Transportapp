package com.example.customers_module.dto;

import java.time.LocalDateTime;
import com.example.customers_module.entity.CustomerEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;



@Data
public class OrderDTO {


    @JsonProperty("_orderId")
    private long orderId;

    private Long customerID;

    private String transportPayer;

//    private LocalDateTime loadingDate;
//    private String loadingStreet;
//    private int loadingHouseNumber;
//    private String loadingCity;
//
//    private int loadingPostalCode;
//
//    private String loadingContactPerson;
//    private int loadingContactPhone;
//
//    private int accountNumber;
//    private int variableSymbol;
//    private int cashOnDelivery;
//
//    private int itemCount;
//    private int packaging;
//    private double totalWeight;
//
//    private String contentDescription;
//    private double packageValue;
//
//    private int length;
//    private int width;
//    private int height;
//
//    private String recipientName;
//    private String recipientStreet;
//    private int recipientHouseNumber;
//    private String recipientCity;
//    private int recipientPostalCode;
//    private int recipientPhoneNumber;
//    private String recipientEmail;
//
//    private String note;


    private CustomerDTO customer;

}
