package com.trueSkillCenter.demoApp.service.impl;

import com.trueSkillCenter.demoApp.entity.Customers;
import com.trueSkillCenter.demoApp.repositories.CustomerRepository;
import com.trueSkillCenter.demoApp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public List<Customers> getAllCustomers() {
        List<Customers> listStudent = customerRepository.findAll();
        return listStudent;
    }

    @Override
    public Customers getCustomers(String uuid) {
        Customers customers = customerRepository.findById(uuid).get();
        return customers;
    }

    @Override
    public Customers addCustomers(Customers customers) {
        return customerRepository.save(customers);
    }

    @Override
    public Customers updateCustomers(Customers customers) {
        customers = customerRepository.save(customers);
        return customers;
    }

    @Override
    public boolean delCustomers(String uuid) {
        Customers customers = customerRepository.findById(uuid).get();
        if (customers != null) {
            customerRepository.deleteById(uuid);
            return true;
        }
        return false;
    }
}
