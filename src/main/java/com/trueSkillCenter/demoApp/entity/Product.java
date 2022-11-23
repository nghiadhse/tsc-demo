package com.trueSkillCenter.demoApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.sql.Blob;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "product")
public class Product {

    @Id
    @Column(name= "productCode", nullable = false)
    private String productCode = UUID.randomUUID().toString();

    @Column(name= "productName", nullable = false)
    @NotBlank
    @Size(min = 1, message = "Product Name name can not be empty")
    @Size(max = 64, message = "Product name can not greater than 64")
    private String productName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productLine", nullable=false)
    private ProductLine productLine;

    @Column(name= "productVendor", nullable = false)
    @NotBlank
    @Size(min = 1, message = "Product Vendor name can not be empty")
    @Size(max = 64, message = "Product Vendor can not greater than 64")
    private String productVendor;

    @Column(name= "productDescription", nullable = false)
    @NotBlank
    @Size(min = 1, message = "Product Vendor name can not be empty")
    private String productDescription;

    @Column(name= "quantityInStock", nullable = false)
    @NotBlank
    @Size(min = 0, message = "Product quantity name can not be zero")
    private Integer quantityInStock;

    @Column(name= "buyPrice", nullable = false)
    @NotBlank
    @Size(min = 0, message = "Price can not be zero")
    private BigDecimal buyPrice;

}
