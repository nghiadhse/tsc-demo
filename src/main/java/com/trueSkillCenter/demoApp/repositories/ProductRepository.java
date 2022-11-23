package com.trueSkillCenter.demoApp.repositories;

import com.trueSkillCenter.demoApp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}
