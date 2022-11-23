package com.trueSkillCenter.demoApp.repositories;

import com.trueSkillCenter.demoApp.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {
}
