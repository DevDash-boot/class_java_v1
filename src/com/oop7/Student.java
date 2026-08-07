package com.oop7;

import java.util.Scanner;

public class Student {
    private String name;    // 이름
    private int money;      // 잔액

    public Student(String n, int m) {
        name = n;
        money = m;
    }

    // 버스 탑승
    void takeBus(Bus bus) {
        if (money >= 1000) {
            bus.takeBus(1000);
            money -= 1000;

        } else {    // 가진 금액이 버스 요금보다 작은 경우
            System.out.println("잔액이 부족합니다.");
        }
    }

    // 지하철 탑승
    void takeSubway(Subway subway) {
        if (money >= 1400) {
            subway.takeSubway(1400);
            money -= 1400;
        } else {    // 가진 금액이 지하철 요금보다 작은 경우
            System.out.println("잔액이 부족합니다.");
        }
    }

    // 식사
    // GoingToSchoolMenu.java에서 stu1.eatRice(rice1, rmn); 실행하면 이 코드가 실행됨
    void eatRice(Rice rice, int rmn) {
        String menuName = rice.RiceMenu(rmn);
        if (money >= rice.money) {
            money -= rice.money;
            System.out.println(menuName);
        }else { // 가진 금액이 음식 가격보다 작은 경우
            System.out.println("잔액이 부족합니다.");
        }
    }

    // 학생 정보 조회
    public void studentInfo() {
        // 잔액 표시
        System.out.println(name + " 님의 현재 잔액: " + money);

    }

}
