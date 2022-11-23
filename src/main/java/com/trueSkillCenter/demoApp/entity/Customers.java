package com.trueSkillCenter.demoApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "customers")
public class Customers {

    @Id
    @Column(name= "customerNumber", nullable = false)
    private String customerNumber = UUID.randomUUID().toString();

    @Column(name= "customerName", nullable = false)
    @NotBlank
    @Size(min = 1, message = "Customer name can not be empty")
    @Size(max = 50, message = "Customer name can not greater than 50")
    private String customerName;

    @Column(name= "contactLastName", nullable = false)
    @NotBlank
    @Size(min = 1, message = "Contact last name can not be empty")
    @Size(max = 50, message = "Contact last name can not greater than 50")
    private String contactLastName;

    @Column(name= "contactFirstName", nullable = false)
    @NotBlank
    @Size(min = 1, message = "Contact first name can not be empty")
    @Size(max = 50, message = "Contact first name can not greater than 50")
    private String contactFirstName;

    @Column(name= "phone", nullable = false)
    @NotBlank
    @Size(min = 1, message = "Phone can not be empty")
    @Size(max = 20, message = "Phone can not greater than 20")
    private String phone;

    @Column(name= "addressLine1", nullable = false)
    @NotBlank
    @Size(min = 1, message = "Address can not be empty")
    private String addressLine1;

    @Column(name= "addressLine2", nullable = true)
    private String addressLine2;

    @Column(name= "city", nullable = false)
    @NotBlank
    @Size(min = 1, message = "City can not be empty")
    @Size(max = 50, message = "City can not greater than 50")
    private String city;

    @Column(name= "state", nullable = true)
    @Size(max = 50, message = "State can not greater than 50")
    private String state;

    @Column(name= "postalCode", nullable = true)
    @Size(max = 15, message = "Postal Code can not greater than 15")
    private String postalCode;

    @Column(name= "country", nullable = false)
    @Size(min = 1, message = "Country can not be empty")
    @Size(max = 50, message = "Country can not greater than 50")
    private String country;

    @Column(name= "creditLimit", nullable = true)
    private BigDecimal creditLimit;

    @OneToMany(mappedBy = "orderNumber", fetch = FetchType.LAZY, orphanRemoval = false)
    private List<Order> listOrder = new ArrayList<>();

}
