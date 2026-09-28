package oop_test.ch06;

import oop_test.ch05.Item;

import java.util.List;

public class OrderService {
    // 1. 직접 생성하지 않고 선언만 함
    private OrderDao dao;

    // 2. 외부에서 생성된 객체를 파라미터로 주입받게 설계(DI) - 핵심!
    public OrderService(OrderDao dao) {
        this.dao = dao;
    }

    public void takeOrder(String menuName, int price){
        Order order = new Order(menuName, price);
        dao.insert(order);
    }

    public void printAllOrders(){
        List<Order> orders  = dao.findAll();
        System.out.println("--- 전체 주문 목록 ---");
        for(Order o : orders){
            System.out.println("메뉴 : " + o.getMenuName() + ", 가격 : " + o.getPrice() + "원");
        }
    }
}
