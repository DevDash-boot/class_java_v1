package com.oop1.Exercise1;

public class OrderMainTest {
    public static void main(String[] args) {
        Order o1 = new Order();

        o1.product = "책";
        o1.price = 10000;
        o1.count = 3;
        o1.payMethod = "card";

        System.out.println("상품: " + o1.product);
        System.out.println("가격: " + o1.price);
        System.out.println("수량: " + o1.count);
        System.out.println("결제방법: " + o1.payMethod);
    }
}
