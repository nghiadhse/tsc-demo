package com.trueSkillCenter.demoApp.controller;

import com.trueSkillCenter.demoApp.dto.APIMessages;
import com.trueSkillCenter.demoApp.entity.Customers;
import com.trueSkillCenter.demoApp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("customer/all")
    public ResponseEntity<List<Customers>> getAll(){
        List<Customers> listcustomer = customerService.getAllCustomers();
        return new ResponseEntity<List<Customers>>(listcustomer, HttpStatus.OK);
    }

    @GetMapping("customer/{id}")
    public ResponseEntity<?> getcustomer(@PathVariable("id") String id){
        if (customerService.getCustomers(id) == null) {
            APIMessages apiErr = new APIMessages("Not Found Customer ID: " + id);
            return new ResponseEntity<APIMessages>(apiErr, HttpStatus.NOT_FOUND);
        } else {
            Customers std = customerService.getCustomers(id);
            return new ResponseEntity<Customers>(std, HttpStatus.OK);
        }
    }

    //Add new customer
    @PostMapping("customer/add")
    public ResponseEntity<?> addcustomer(@Validated @RequestBody Customers std){
        Customers dataStd = customerService.addCustomers(std);
        if (dataStd != null) {
            return new ResponseEntity<Customers>(dataStd, HttpStatus.OK);
        }
        APIMessages apiErr = new APIMessages("Can not create customer ");
        return new ResponseEntity<APIMessages>(apiErr, HttpStatus.NOT_FOUND);
    }

    @PutMapping("customer/{id}")
    public ResponseEntity<?> updatecustomer(@PathVariable("id") String id, @Validated @RequestBody Customers std){
        Customers dataStd = customerService.getCustomers(id);
        if (dataStd == null) {
            APIMessages apiErr = new APIMessages("Not found customer id: "+ id);
            return new ResponseEntity<APIMessages>(apiErr, HttpStatus.NOT_FOUND);
        } else {
            dataStd.setCustomerName(std.getCustomerName());
            dataStd.setContactLastName(std.getContactLastName());
            dataStd.setContactFirstName(std.getContactFirstName());
            dataStd.setPhone(std.getPhone());
            dataStd.setAddressLine1(std.getAddressLine1());
            dataStd.setAddressLine2(std.getAddressLine2());
            dataStd.setCity(std.getCity());
            dataStd.setState(std.getState());
            dataStd.setPostalCode(std.getPostalCode());
            dataStd.setCountry(std.getCountry());
            dataStd.setCreditLimit(std.getCreditLimit());
            customerService.updateCustomers(dataStd);
            return new ResponseEntity<Customers>(dataStd, HttpStatus.OK);
        }
    }

    @DeleteMapping("customer/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") String id){
        Customers dataStd = customerService.getCustomers(id);
        if (dataStd == null) {
            APIMessages apiErr = new APIMessages("Not found customer id: "+ id);
            return new ResponseEntity<APIMessages>(apiErr, HttpStatus.NOT_FOUND);
        } else {
            customerService.delCustomers(id);
            APIMessages apiErr = new APIMessages("Deleted customer id: "+ id);
            return new ResponseEntity<APIMessages>(apiErr, HttpStatus.OK);
        }
    }

}
