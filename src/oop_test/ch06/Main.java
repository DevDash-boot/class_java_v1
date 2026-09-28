package oop_test.ch06;

public class Main {
    public static void main(String[] args) {
        // 1. 사용할 부품 DAO를 먼저 생성
        OrderDao orderDao = new OrderDao();
        // 2. 서비스 객체를 생성할 때 부분(Dao)를 주입 받도록 설계되어 있다.
        OrderService service = new OrderService(orderDao);  //DI
        service.takeOrder("아메리카노", 4500);
        service.takeOrder("카페라떼", 5000);
        service.takeOrder("바닐라라떼", 5500);

        service.printAllOrders();
    }
}
