package com.oop5;

public class Subway {
    int lineNum; // 1호선, 2호선
    int count;  // 탑승객 수
    int money;  // 수익금

    // 1. 생성자
    public Subway(int num){
        lineNum = num;
    }

    // 2. 승객을 태운다
    void takeSubway(int pay){
        money += pay;
        count++;
    }

    // 3. 정보보기
    void subwayInfo(){
        System.out.println("호선: " + lineNum);
        System.out.println("탑승객 수: "+ count);
        System.out.println("현재 수익: " + money);
    }


}
