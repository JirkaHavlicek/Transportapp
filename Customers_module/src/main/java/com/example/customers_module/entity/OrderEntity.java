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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderId_seq_gen")
    @SequenceGenerator(name = "orderId_seq_gen", sequenceName = "orderId_id_seq")
    private Long orderId;

    @ManyToOne
    @JoinTable (name = "customer")
    private CustomerEntity customerId;

    private String transportPayer;

    // Sender details
    private LocalDateTime loadingDate;

    @Column(nullable = false)
    private String loadingAddress;

    @Column(nullable = false)
    private String loadingStreet;

    @Column(nullable = false)
    private int loadingHouseNumber;

    @Column(nullable = false)
    private String loadingCity;

    @Column(nullable = false)
    private int loadingPostalCode;

    @Column(nullable = false)
    private String loadingContactPerson;

    @Column(nullable = false)
    private int loadingContactPhone;

    private int accountNumber;
    private int variableSymbol;
    private int cashOnDelivery;

    // Package details
    private int itemCount;
    private String packaging;
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