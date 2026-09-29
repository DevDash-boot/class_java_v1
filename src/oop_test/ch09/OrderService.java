package oop_test.ch09;

// 비즈니스 로직 객체 (주입 대상)
public class OrderService {
    private DiscountPolicy discountPolicy;

    public OrderService(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    public void takeOrder(String MenuName, int price) {
        Order newOrder = new Order(MenuName, price);
        int discountAmount = discountPolicy.discount(newOrder.getPrice());
        int finalPrice = newOrder.getPrice() - discountAmount;
        System.out.println(newOrder.getMenuName() + " | 정가 : " + newOrder.getPrice() +
                "원 | 할인 : " + discountAmount + "원 | 결제 금액 : " + finalPrice + "원");
    }
}
