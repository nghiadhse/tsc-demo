package com.trueSkillCenter.demoApp.repositories;

import com.trueSkillCenter.demoApp.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customers, String> {
}
