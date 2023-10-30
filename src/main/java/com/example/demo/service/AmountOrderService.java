package com.example.demo.service;

//@Service
public class AmountOrderService implements OrderService {

    private final int DISCOUNT_AMOUNT =100;
    @Override
    public int getPrice(int price) {
        return price-DISCOUNT_AMOUNT;
    }
}
