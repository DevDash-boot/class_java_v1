package oop_test.ch10;

import java.util.List;

public class OrderService {
    private OrderDao dao;
    private DiscountPolicy discountPolicy;

    public OrderService(OrderDao dao, DiscountPolicy discountPolicy) {
        this.dao = dao;
        this.discountPolicy = discountPolicy;
    }

    public void takeOrder(String menuName, int price) {
        Order newOrder = new Order(menuName, price);
        dao.insert(newOrder);
    }

    public void printAllOrders() {
        List<Order> orders = dao.findAll();
        System.out.println("--- 전체 주문 내역 ---");
        for (Order order : orders) {
            int discountAmount = discountPolicy.discount(order.getPrice());
            int finalPrice = order.getPrice() - discountAmount;
            System.out.printf("메뉴 : %s | 정가 : %d원 | 할인 : %d원 | 결제 금액 : %d원\n",
                    order.getMenuName(), order.getPrice(), discountAmount, finalPrice);
        }
    }
}
