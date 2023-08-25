package com.example.customers_module.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity(name = "order")
@Getter
@Setter
public class OrderEntity {
    @Id
    @SequenceGenerator(name = "order_seq", sequenceName = "order_seq", allocationSize = 1)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customerId;

    private String transportPayer;

    // Sender details
    private LocalDateTime loadingDate;

    @Column(nullable = false)
    private String loadingAddress;

    @Column(nullable = false)
    private String loadingContactPerson;

    @Column(nullable = false)
    private String loadingContactPhone;

    private int accountNumber;
    private int variableSymbol;
    private int CashOnDelivery;

    // Package details
    private int itemCount;
    private int packaging;
    @Column(nullable = false)
    private double totalWeight;

    private String contentDescription;
    private double packageValue;

    @Column(nullable = false)
    private int length;

    @Column(nullable = false)
    private int width;

    @Column(nullable = false)
    private int height;

    // Recipient details
    @Column(nullable = false)
    private String recipientName;

    @Column(nullable = false)
    private String recipientStreet;

    @Column(nullable = false)
    private int recipientHouseNumber;

    @Column(nullable = false)
    private String recipientCity;

    @Column(nullable = false)
    private int recipientPostalCode;

    @Column(nullable = false)
    private int recipientPhoneNumber;

    @Column(nullable = false)
    private String recipientEmail;

    private String note;





}