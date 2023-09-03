package com.example.customers_module.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity(name = "orders")
@Getter
@Setter
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderId_seq_gen")
    @SequenceGenerator(name = "orderId_seq_gen", sequenceName = "orderId_id_seq")
    private Long id;

    @ManyToOne
    private CustomerEntity customers;

    private String transportPayer;

    // Sender details
//    private LocalDateTime loadingDate;
//    private String loadingAddress;
//    private String loadingStreet;
//    private int loadingHouseNumber;
//    private String loadingCity;
//    private int loadingPostalCode;
//    private int loadingContactPerson;
//    private int loadingContactPhone;
//
//    private int accountNumber;
//    private int variableSymbol;
//    private int cashOnDelivery;
//
//    // Package details
//    private int itemCount;
//    private String packaging;
//
//    private double totalWeight;
//
//    private String contentDescription;
//    private double packageValue;
//
//    private int length;
//
//    private int width;
//
//    private int height;
//
//    // Recipient details
//    private String recipientName;
//    private String recipientStreet;
//    private int recipientHouseNumber;
//    private String recipientCity;
//    private int recipientPostalCode;
//    private int recipientPhoneNumber;
//    private String recipientEmail;
//
//    private String note;

}