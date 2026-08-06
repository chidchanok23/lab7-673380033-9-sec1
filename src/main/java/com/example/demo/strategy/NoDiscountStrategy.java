package com.example.demo.strategy;


import org.springframework.stereotype.Component;

@Component
public class NoDiscountStrategy implements DiscountStrategy {

    @Override
    public double calculateDiscount(double price) {
        return price;
    }

    @Override
    public String getDiscountName() {
        return "ราคาปกติ";
    }
}
