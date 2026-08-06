package com.example.demo.strategy;

import org.springframework.stereotype.Component;

@Component
public class StudentDiscountStrategy implements DiscountStrategy {

    @Override
    public double calculateDiscount(double price) {
        return price * 0.90;
    }

    @Override
    public String getDiscountName() {
        return "ส่วนลดนักศึกษา (10%)";
    }
}
