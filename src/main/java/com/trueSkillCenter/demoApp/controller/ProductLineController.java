package com.trueSkillCenter.demoApp.controller;

import com.trueSkillCenter.demoApp.dto.APIMessages;
import com.trueSkillCenter.demoApp.entity.Customers;
import com.trueSkillCenter.demoApp.entity.ProductLine;
import com.trueSkillCenter.demoApp.service.ProductLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class ProductLineController {

    @Autowired
    private ProductLineService productLineService;

    @GetMapping("productLine/all")
    public ResponseEntity<List<ProductLine>> getAll(){
        List<ProductLine> productLines = productLineService.getAllProductLine();
        return new ResponseEntity<List<ProductLine>>(productLines, HttpStatus.OK);
    }

    @GetMapping("productLine/{id}")
    public ResponseEntity<?> getProductLine(@PathVariable("id") String id){
        if (productLineService.getProductLine(id) == null) {
            APIMessages apiErr = new APIMessages("Not Found Customer ID: " + id);
            return new ResponseEntity<APIMessages>(apiErr, HttpStatus.NOT_FOUND);
        } else {
            ProductLine std = productLineService.getProductLine(id);
            return new ResponseEntity<ProductLine>(std, HttpStatus.OK);
        }
    }

    //Add new customer
    @PostMapping("productLine/add")
    public ResponseEntity<?> addProductLine(@Validated @RequestBody ProductLine std){
        ProductLine dataStd = productLineService.addProductLine(std);
        if (dataStd != null) {
            return new ResponseEntity<ProductLine>(dataStd, HttpStatus.OK);
        }
        APIMessages apiErr = new APIMessages("Can not create customer ");
        return new ResponseEntity<APIMessages>(apiErr, HttpStatus.NOT_FOUND);
    }

    @PutMapping("productLine/{id}")
    public ResponseEntity<?> updatecustomer(@PathVariable("id") String id, @Validated @RequestBody ProductLine std){
        ProductLine dataStd = productLineService.getProductLine(id);
        if (dataStd == null) {
            APIMessages apiErr = new APIMessages("Not found productline id: "+ id);
            return new ResponseEntity<APIMessages>(apiErr, HttpStatus.NOT_FOUND);
        } else {
            dataStd.setProductLine(std.getProductLine());
            dataStd.setTextDescription(std.getTextDescription());
            dataStd.setHtmlDescription(std.getHtmlDescription());
            dataStd.setImage(std.getImage());
            productLineService.updateProductLine(dataStd);
            return new ResponseEntity<ProductLine>(dataStd, HttpStatus.OK);
        }
    }

    @DeleteMapping("productLine/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") String id){
        ProductLine dataStd = productLineService.getProductLine(id);
        if (dataStd == null) {
            APIMessages apiErr = new APIMessages("Not found product line id: "+ id);
            return new ResponseEntity<APIMessages>(apiErr, HttpStatus.NOT_FOUND);
        } else {
            productLineService.delProductLine(id);
            APIMessages apiErr = new APIMessages("Deleted line id: "+ id);
            return new ResponseEntity<APIMessages>(apiErr, HttpStatus.OK);
        }
    }

}
