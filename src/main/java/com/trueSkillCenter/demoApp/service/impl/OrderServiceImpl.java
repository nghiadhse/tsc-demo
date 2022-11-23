package com.trueSkillCenter.demoApp.service.impl;

import com.trueSkillCenter.demoApp.entity.Order;
import com.trueSkillCenter.demoApp.repositories.OrderRepository;
import com.trueSkillCenter.demoApp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository OrderRepository;


    @Override
    public List<Order> getAllOrder() {
        List<Order> listOrder = OrderRepository.findAll();
        return listOrder;
    }

    @Override
    public Order getOrder(String uuid) {
        Order customers = OrderRepository.findById(uuid).get();
        return customers;
    }

    @Override
    public Order addOrder(Order Order) {
        return OrderRepository.save(Order);
    }

    @Override
    public Order updateOrder(Order Order) {
        Order = OrderRepository.save(Order);
        return Order;
    }

    @Override
    public boolean delOrder(String uuid) {
        Order Order = OrderRepository.findById(uuid).get();
        if (Order != null) {
            OrderRepository.deleteById(uuid);
            return true;
        }
        return false;
    }
}
