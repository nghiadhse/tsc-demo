package com.trueSkillCenter.demoApp.service;

import com.trueSkillCenter.demoApp.entity.Order;

import java.util.List;

public interface OrderService {

    public List<Order> getAllOrder();

    public Order getOrder(String uuid);

    public Order addOrder(Order customers);

    public Order updateOrder(Order customers);

    public boolean delOrder(String uuid);

}