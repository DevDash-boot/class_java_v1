package oop_test.ch10;

public class Main {
    public static void main(String[] args) {
        OrderDao orderDao1 = new MemoryOrderDao();  // 리스트에 저장하는 구현체
        OrderDao orderDao2 = new LogOrderDao(); // 저장하지 않고 콘솔창에 로그만 출력하는 구현체

        DiscountPolicy discountPolicy1 = new FixDiscountPolicy();   // 고정 할인 구현체
        DiscountPolicy discountPolicy2 = new RateDiscountPolicy();  // 비율 할인 구현체

        OrderService service = new OrderService(orderDao1, discountPolicy2);

        service.takeOrder("아메리카노", 4500);
        service.takeOrder("카페라떼", 5000);
        service.takeOrder("바닐라라떼", 5500);

        service.printAllOrders();
    }
}
