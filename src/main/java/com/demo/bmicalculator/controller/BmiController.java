package com.demo.bmicalculator.controller;

import com.demo.bmicalculator.entity.DietPlan;
import com.demo.bmicalculator.service.BmiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

@Controller
public class BmiController {

    @Autowired
    private BmiService bmiService;

    @GetMapping("/")
    public String welcome() {
        return "welcome";
    }

    @GetMapping("/details")
    public String details(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_HOME");
       return "details";
   }
  

    @PostMapping("/results")
    public ModelAndView results(@ModelAttribute("height") String height, @ModelAttribute("weight") String weight, BindingResult bindingResult, HttpServletRequest request) {
        BigDecimal bmi = bmiService.calculateBMI(height, weight);
        DietPlan dietPlan = bmiService.getBmiResults(bmi);
        ModelAndView mav = new ModelAndView("results");
        mav.addObject("bmi", bmi);
        mav.addObject("category", dietPlan.getCategory());
        mav.addObject("tips", dietPlan.getTips());
        return mav;
    }

    @GetMapping("/results")
    public String getResults() {
        return "results";
    }
}
