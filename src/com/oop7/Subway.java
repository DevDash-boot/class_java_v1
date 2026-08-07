package com.oop7;

public class Subway {

    private int subline;    // 노선 번호
    private int money;      // 요금
    private int count;      // 탑승객 수

    public Subway(int n, int m) {
        subline = n;
        money = m;
    }

    void takeSubway(int pay) {  // 탑승
        money += pay;
        count++;
        System.out.println(subline + "노선을 탑승했습니다.");
        System.out.println("지하철 요금 " + pay + "원을 결제합니다.");
    }

    public void subwayInfo() {
        System.out.println("===== 지하철 조회 =====");
        System.out.println("지하철 노선: " + subline);
        System.out.println("현재 탑승객 수: " + count);
        System.out.println("수익:" + money);
    }

}
