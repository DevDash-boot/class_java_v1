package com.oop5;

public class Bus {

    int busNumber;  // 버스번호
    int count;      // 탑승 승객 수
    int money;      // 요금

    // 멤버 변수를 생성자를 통해서 초기화하지 않는다면 자동으로 기본값을 가진다.

    public Bus(int num) {
        busNumber = num;
    }

    // 행위: 사람을 태우다.
    void take(int pay) {
        money += pay;
        count++;
    }

    // 현재 버스의 상태를 보여주는 메서드
    void busInfo() {
        System.out.println("버스 번호: " + busNumber);
        System.out.println("현재 탑승객 수: " + count);
        System.out.println("현재 수익: " + money);
    }

}
