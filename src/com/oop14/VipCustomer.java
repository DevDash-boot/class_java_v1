package com.oop14;

public class VipCustomer extends Customer{

    private int agentId;
    private double saleRatio;

    public VipCustomer(int customerID, String customerName){
        super(customerID, customerName);

        customerGrade = "VIP";
        bonusRatio =  0.05;
        saleRatio = 0.2;
        this.agentId = agentId;
    }
    public int CalcPrice(int price){
        bonusPoint += price * bonusRatio;
        return price - (int)(price * saleRatio);
    }

    public int getAgentId(){

        return agentId;
    }
}
