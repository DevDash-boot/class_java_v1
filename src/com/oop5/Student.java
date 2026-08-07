package com.oop5;

public class Student {
    String name;
    int money;

    public Student(String n, int m) {
        name = n;
        money = m;
    }

    // 메서드 1. 버스를 탄다.
    void takeBus(Bus bus) {
        // 자기 일은 스스로 해결한다.
        bus.take(1000); // 버스 요금 1000원 결제
        money -= 1000;
    }

    // 메서드 2. 지하철을 탄다.
    void takeSubway(Subway subway) {
        subway.takeSubway(500);
        money -= 500;
    }

    // 메서드 3. 학생이 밥을 먹는다(남은 양이 없으면 밥을 다 먹었습니다)
    void eatRice(Rice rice){
        // retrun값은 true or false
        int amount =100;
        if(rice.reduce(amount)){
            System.out.println(name + "님이 " + rice.menu + "을(를) "+  amount + "만큼 먹었습니다.");
        } else {
            System.out.println("밥을 다 먹었거나, 양이 부족합니다.");
        }
    }

    // 메서드. 정보창 기능
    void studentInfo() {
        System.out.println(name + "님의 현재 남은 금액: " + money);
    }

}
