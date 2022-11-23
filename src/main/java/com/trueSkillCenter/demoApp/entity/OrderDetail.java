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
@Entity(name = "orderdetails")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name= "quantityOrdered", nullable = false)
    @NotBlank
    private Integer quantityOrdered;

    @Column(name= "priceEach", nullable = false)
    @NotBlank
    private BigDecimal priceEach;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderNumber", referencedColumnName = "orderNumber")
    private Order order;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "productCode", referencedColumnName = "productCode")
    private Product product;

}
