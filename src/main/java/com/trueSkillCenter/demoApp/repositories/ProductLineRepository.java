package com.trueSkillCenter.demoApp.repositories;

import com.trueSkillCenter.demoApp.entity.ProductLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductLineRepository extends JpaRepository<ProductLine, String> {
}
