package oop_test.ch08;

import java.util.ArrayList;
import java.util.List;

// 구현체 2 : 저장하지 않고 콘솔창에 로그만 출력하는 구현체
public class LogOrderDao implements OrderDao {

    @Override
    public void insert(Order order) {
        System.out.println("[LOG] 주문 요청 - 메뉴: " + order.getMenuName() + ", 가격: " + order.getPrice() + "원 (저장하지 않음)");
    }

    @Override
    public List<Order> findAll() {
        System.out.println("[LOG] 조회 요청 - 저장된 내역이 없습니다.");
        return new ArrayList<>();
    }
}