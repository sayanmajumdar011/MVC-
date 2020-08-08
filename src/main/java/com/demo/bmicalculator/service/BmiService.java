package com.demo.bmicalculator.service;

import com.demo.bmicalculator.entity.DietPlan;
import com.demo.bmicalculator.repository.DietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class BmiService {

    @Autowired
    private DietRepository dietRepository;

    public BigDecimal calculateBMI(String height, String weight) {
        BigDecimal heightInCentimeters = new BigDecimal(height);
        BigDecimal heightInMeters = heightInCentimeters.divide(new BigDecimal(100), 2, RoundingMode.HALF_EVEN);
        BigDecimal weightInKg = new BigDecimal(weight);
        BigDecimal bmi = weightInKg.divide(heightInMeters.pow(2), 2, RoundingMode.HALF_EVEN);
        return bmi;
    }

    public DietPlan getBmiResults(BigDecimal bmi) {
        String category;
        if (bmi.compareTo(new BigDecimal(18.5)) < 0) {
            category = "UNDER_WEIGHT";
        } else if (bmi.compareTo(new BigDecimal(18.5)) > -1 && bmi.compareTo(new BigDecimal(25)) < 0) {
            category = "NORMAL";
        } else {
            category = "OVER_WEIGHT";
        }
        return dietRepository.findByCategory(category);
    }
}
