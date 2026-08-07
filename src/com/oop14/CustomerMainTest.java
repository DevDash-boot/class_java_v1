package com.oop14;

public class CustomerMainTest {
    public static void main(String[] args) {
        Customer[] customers = new Customer[4];

        customers[0] = new Customer(12, "김철수");
        customers[1] = new Customer(51, "홍길동");
        customers[2] = new GoldCustomer(1001, "둘리");
        customers[3] = new VipCustomer(10157, "제리");

        int price = 10000;
        System.out.println("Basic: " + customers[0].CalcPrice(price));
        System.out.println("Gold: " + customers[2].CalcPrice(price));
        System.out.println("VI{: " + customers[3].CalcPrice(price));

        for(int i=0;i< customers.length;i++){
            customers[i].showCustomerInfo();
        }
    }
}
