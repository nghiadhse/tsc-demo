package com.trueSkillCenter.demoApp.controller;

import com.trueSkillCenter.demoApp.dto.APIMessages;
import com.trueSkillCenter.demoApp.entity.Product;
import com.trueSkillCenter.demoApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("product/all")
    public ResponseEntity<List<Product>> getAll(){
        List<Product> products = productService.getAllProduct();
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }

    @GetMapping("product/{id}")
    public ResponseEntity<?> getProduct(@PathVariable("id") String id){
        if (productService.getProduct(id) == null) {
            APIMessages apiErr = new APIMessages("Not Found Customer ID: " + id);
            return new ResponseEntity<APIMessages>(apiErr, HttpStatus.NOT_FOUND);
        } else {
            Product std = productService.getProduct(id);
            return new ResponseEntity<Product>(std, HttpStatus.OK);
        }
    }

    //Add new customer
    @PostMapping("product/add")
    public ResponseEntity<?> addProduct(@Validated @RequestBody Product std){
        Product dataStd = productService.addProduct(std);
        if (dataStd != null) {
            return new ResponseEntity<Product>(dataStd, HttpStatus.OK);
        }
        APIMessages apiErr = new APIMessages("Can not create customer ");
        return new ResponseEntity<APIMessages>(apiErr, HttpStatus.NOT_FOUND);
    }

    @PutMapping("product/{id}")
    public ResponseEntity<?> updatecustomer(@PathVariable("id") String id, @Validated @RequestBody Product std){
        Product dataStd = productService.getProduct(id);
        if (dataStd == null) {
            APIMessages apiErr = new APIMessages("Not found product id: "+ id);
            return new ResponseEntity<APIMessages>(apiErr, HttpStatus.NOT_FOUND);
        } else {
            dataStd.setProductCode(std.getProductCode());
            dataStd.setProductLine(std.getProductLine());
            dataStd.setProductName(std.getProductName());
            dataStd.setProductVendor(std.getProductVendor());
            dataStd.setProductDescription(std.getProductDescription());
            dataStd.setQuantityInStock(std.getQuantityInStock());
            dataStd.setBuyPrice(std.getBuyPrice());
            productService.updateProduct(dataStd);
            return new ResponseEntity<Product>(dataStd, HttpStatus.OK);
        }
    }

    @DeleteMapping("product/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") String id){
        Product dataStd = productService.getProduct(id);
        if (dataStd == null) {
            APIMessages apiErr = new APIMessages("Not found product  id: "+ id);
            return new ResponseEntity<APIMessages>(apiErr, HttpStatus.NOT_FOUND);
        } else {
            productService.delProduct(id);
            APIMessages apiErr = new APIMessages("Deleted  id: "+ id);
            return new ResponseEntity<APIMessages>(apiErr, HttpStatus.OK);
        }
    }

}
