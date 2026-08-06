package com.example.demo.strategy;


import org.springframework.stereotype.Component;

@Component
public class DiscountContext {

    private final NoDiscountStrategy noDiscountStrategy;
    private final StudentDiscountStrategy studentDiscountStrategy;
    private final SeasonalSaleStrategy seasonalSaleStrategy;

    public DiscountContext(NoDiscountStrategy noDiscountStrategy,
                           StudentDiscountStrategy studentDiscountStrategy,
                           SeasonalSaleStrategy seasonalSaleStrategy) {

        this.noDiscountStrategy = noDiscountStrategy;
        this.studentDiscountStrategy = studentDiscountStrategy;
        this.seasonalSaleStrategy = seasonalSaleStrategy;
    }

    public DiscountStrategy getStrategy(String discountType) {

        if (discountType == null) {
            return noDiscountStrategy;
        }

        switch (discountType.toUpperCase()) {

            case "STUDENT":
                return studentDiscountStrategy;

            case "SEASONAL":
                return seasonalSaleStrategy;

            case "NONE":
            default:
                return noDiscountStrategy;
        }
    }
}
