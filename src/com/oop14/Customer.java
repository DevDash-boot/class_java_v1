package com.oop14;

public class Customer {
    private int customerID;
    private String customerName;
    protected String customerGrade;
    protected int bonusPoint;
    protected double bonusRatio;


    public Customer(int customerID, String customerName) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerGrade = "Basic";
        this.bonusRatio = 0.01;
    }

    public int CalcPrice(int price) {
        bonusPoint = (int) (bonusPoint + price * bonusRatio);
        return price;
    }

    public void showCustomerInfo() {
        System.out.println("=== 고객 정보 ===");
        System.out.println("고객 아이디:" + customerID);
        System.out.println("고객 이름: " + customerName);
        System.out.println("고객 등급: " + customerGrade);
        System.out.println("보너스 포인트: " + bonusPoint);
        System.out.println("보너스 포인트 적립 비율: " + bonusRatio + "\n");
    }
}
