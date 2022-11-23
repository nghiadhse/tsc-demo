package com.trueSkillCenter.demoApp.service.impl;

import com.trueSkillCenter.demoApp.entity.Product;
import com.trueSkillCenter.demoApp.repositories.ProductRepository;
import com.trueSkillCenter.demoApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Product> getAllProduct() {
        List<Product> listProduct = productRepository.findAll();
        return listProduct;
    }

    @Override
    public Product getProduct(String uuid) {
        Product customers = productRepository.findById(uuid).get();
        return customers;
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        product = productRepository.save(product);
        return product;
    }

    @Override
    public boolean delProduct(String uuid) {
        Product product = productRepository.findById(uuid).get();
        if (product != null) {
            productRepository.deleteById(uuid);
            return true;
        }
        return false;
    }
}
