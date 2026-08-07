package com.oop14;

public class GoldCustomer extends Customer{

    private double saleRatio;

    public GoldCustomer(int customerID, String customerName) {
        super(customerID, customerName);

        customerGrade = "Gold";
        bonusRatio = 0.03;
        saleRatio = 0.1;
    }

    public int CalcPrice(int price){
        bonusPoint += price * bonusRatio;
        return price - (int)(price * saleRatio);
    }


}
