package com.trueSkillCenter.demoApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "productlines")
public class ProductLine {

    @Id
    @Column(name= "productLine", nullable = false)
    private String productLine;

    @Column(name= "textDescription", nullable = true)
    @NotBlank
    @Size(min = 1, message = "Description name can not be empty")
    @Size(max = 4000, message = "Description name can not greater than 4000")
    private String textDescription;

    @Column(name= "htmlDescription", nullable = true)
    @NotBlank
    @Size(min = 1, message = "HTML Description name can not be empty")
    @Size(max = 4000, message = "HTML Description name can not greater than 4000")
    private String htmlDescription;

    @Column(name= "image", nullable = true)
    @Lob
    private Blob image;

    @OneToMany(mappedBy = "productCode", fetch = FetchType.LAZY, orphanRemoval = false)
    private List<Product> listProduct = new ArrayList<>();

}
