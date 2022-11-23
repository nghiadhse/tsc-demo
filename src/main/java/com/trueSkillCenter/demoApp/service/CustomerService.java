package com.trueSkillCenter.demoApp.service;

import com.trueSkillCenter.demoApp.entity.Customers;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    public List<Customers> getAllCustomers();

    public Customers getCustomers(String uuid);

    public Customers addCustomers(Customers customers);

    public Customers updateCustomers(Customers customers);

    public boolean delCustomers(String uuid);

}