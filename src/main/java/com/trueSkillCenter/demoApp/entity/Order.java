package com.trueSkillCenter.demoApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "orders")
public class Order {

    @Id
    @Column(name= "orderNumber", nullable = false)
    private String orderNumber = UUID.randomUUID().toString();

    @Column(name= "orderDate", nullable = false)
    @NotBlank
    private Date orderDate;

    @Column(name= "requiredDate", nullable = false)
    @NotBlank
    private Date requiredDate;

    @Column(name= "shippedDate", nullable = true)
    @NotBlank
    private Date shippedDate = null;

    @Column(name= "status", nullable = false)
    @NotBlank
    @Size(min = 1, message = "Status can not be empty")
    @Size(min = 15, message = "Status can not more than 15")
    private String status;

    @Column(name= "comments", nullable = true)
    private String comments = null;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerNumber", nullable=false)
    private Customers customers;

}
