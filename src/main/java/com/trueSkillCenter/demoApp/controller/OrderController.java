package com.trueSkillCenter.demoApp.controller;

import com.trueSkillCenter.demoApp.dto.APIMessages;
import com.trueSkillCenter.demoApp.entity.Order;
import com.trueSkillCenter.demoApp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class OrderController {

    @Autowired
    private OrderService OrderService;

    @GetMapping("Order/all")
    public ResponseEntity<List<Order>> getAll(){
        List<Order> Orders = OrderService.getAllOrder();
        return new ResponseEntity<List<Order>>(Orders, HttpStatus.OK);
    }

    @GetMapping("Order/{id}")
    public ResponseEntity<?> getOrder(@PathVariable("id") String id){
        if (OrderService.getOrder(id) == null) {
            APIMessages apiErr = new APIMessages("Not Found Customer ID: " + id);
            return new ResponseEntity<APIMessages>(apiErr, HttpStatus.NOT_FOUND);
        } else {
            Order std = OrderService.getOrder(id);
            return new ResponseEntity<Order>(std, HttpStatus.OK);
        }
    }

    //Add new customer
    @PostMapping("Order/add")
    public ResponseEntity<?> addOrder(@Validated @RequestBody Order std){
        Order dataStd = OrderService.addOrder(std);
        if (dataStd != null) {
            return new ResponseEntity<Order>(dataStd, HttpStatus.OK);
        }
        APIMessages apiErr = new APIMessages("Can not create customer ");
        return new ResponseEntity<APIMessages>(apiErr, HttpStatus.NOT_FOUND);
    }

    @PutMapping("Order/{id}")
    public ResponseEntity<?> updatecustomer(@PathVariable("id") String id, @Validated @RequestBody Order std){
        Order dataStd = OrderService.getOrder(id);
        if (dataStd == null) {
            APIMessages apiErr = new APIMessages("Not found Order id: "+ id);
            return new ResponseEntity<APIMessages>(apiErr, HttpStatus.NOT_FOUND);
        } else {
            dataStd.setOrderNumber(std.getOrderNumber());
            dataStd.setCustomers(std.getCustomers());
            dataStd.setComments(std.getComments());
            dataStd.setOrderDate(std.getOrderDate());
            dataStd.setStatus(std.getStatus());
            dataStd.setRequiredDate(std.getRequiredDate());
            dataStd.setShippedDate(std.getShippedDate());
            OrderService.updateOrder(dataStd);
            return new ResponseEntity<Order>(dataStd, HttpStatus.OK);
        }
    }

    @DeleteMapping("Order/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") String id){
        Order dataStd = OrderService.getOrder(id);
        if (dataStd == null) {
            APIMessages apiErr = new APIMessages("Not found Order  id: "+ id);
            return new ResponseEntity<APIMessages>(apiErr, HttpStatus.NOT_FOUND);
        } else {
            OrderService.delOrder(id);
            APIMessages apiErr = new APIMessages("Deleted  id: "+ id);
            return new ResponseEntity<APIMessages>(apiErr, HttpStatus.OK);
        }
    }

}
