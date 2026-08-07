package com.oop7;

public class Bus {

    private int busNum; // 버스 번호
    private int money;  // 요금
    private int count;  // 탑승객 수

    public Bus(int n, int m) {
        busNum = n;
        money = m;
    }

    void takeBus(int pay) {  // 탑승
        money += pay;
        count++;

        System.out.println(busNum + " 번 버스를 탑승했습니다.");
        System.out.println("버스 요금 " + pay + "원을 결제합니다.");
    }

    public void busInfo() {
        System.out.println("===== 버스 조회 =====");
        System.out.println("버스 번호: " + busNum);
        System.out.println("현재 탑승객 수: " + count);
        System.out.println("수익:" + money);
    }

}
