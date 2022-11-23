package com.trueSkillCenter.demoApp.service.impl;

import com.trueSkillCenter.demoApp.entity.Customers;
import com.trueSkillCenter.demoApp.entity.ProductLine;
import com.trueSkillCenter.demoApp.repositories.CustomerRepository;
import com.trueSkillCenter.demoApp.repositories.ProductLineRepository;
import com.trueSkillCenter.demoApp.service.CustomerService;
import com.trueSkillCenter.demoApp.service.ProductLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductLineServiceImpl implements ProductLineService {

    @Autowired
    private ProductLineRepository productLineRepository;


    @Override
    public List<ProductLine> getAllProductLine() {
        List<ProductLine> listProductLine = productLineRepository.findAll();
        return listProductLine;
    }

    @Override
    public ProductLine getProductLine(String uuid) {
        ProductLine customers = productLineRepository.findById(uuid).get();
        return customers;
    }

    @Override
    public ProductLine addProductLine(ProductLine productLine) {
        return productLineRepository.save(productLine);
    }

    @Override
    public ProductLine updateProductLine(ProductLine productLine) {
        productLine = productLineRepository.save(productLine);
        return productLine;
    }

    @Override
    public boolean delProductLine(String uuid) {
        ProductLine productLine = productLineRepository.findById(uuid).get();
        if (productLine != null) {
            productLineRepository.deleteById(uuid);
            return true;
        }
        return false;
    }
}
