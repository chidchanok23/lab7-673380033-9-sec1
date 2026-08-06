package com.example.demo.strategy;

import org.springframework.stereotype.Component;

@Component
public class SeasonalSaleStrategy implements DiscountStrategy {

    @Override
    public double calculateDiscount(double price) {
        return price * 0.80;
    }

    @Override
    public String getDiscountName() {
        return "ส่วนลดเทศกาล (20%)";
    }
}
