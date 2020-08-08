package com.demo.bmicalculator.repository;

import com.demo.bmicalculator.entity.DietPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DietRepository  extends JpaRepository<DietPlan, String> {
    DietPlan findByCategory(String category);
}
