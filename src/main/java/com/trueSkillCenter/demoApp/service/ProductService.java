package com.trueSkillCenter.demoApp.service;

import com.trueSkillCenter.demoApp.entity.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getAllProduct();

    public Product getProduct(String uuid);

    public Product addProduct(Product customers);

    public Product updateProduct(Product customers);

    public boolean delProduct(String uuid);

}