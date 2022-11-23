package com.trueSkillCenter.demoApp.service;

import com.trueSkillCenter.demoApp.entity.Customers;
import com.trueSkillCenter.demoApp.entity.ProductLine;

import java.util.List;

public interface ProductLineService {

    public List<ProductLine> getAllProductLine();

    public ProductLine getProductLine(String uuid);

    public ProductLine addProductLine(ProductLine customers);

    public ProductLine updateProductLine(ProductLine customers);

    public boolean delProductLine(String uuid);

}