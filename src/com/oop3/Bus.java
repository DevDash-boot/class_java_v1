package com.oop3;

// 버스 클래스 설계
// 속성과 행위를 설계
// BusMainTest1 (객체를 2개 이상 생성하고 결과 출력)

public class Bus {

    // 속성(+ 승객 수, 최대 탑승객 수, 결제 방법, 수익금)
    int busNumber;  // 버스 번호
    String station; // 정거장
    String passenger;   // 승객
    int pirce;  // 요금
    int time;   // 도착 시간

    // 행위
    void stop(){    // 도착 전
        System.out.println(busNumber + "번 버스가 "+ time + "분 후 " + station + " 정거장에 도착합니다.");
    }
    void arrive(){  // 도착
        System.out.println(busNumber + "번 버스가 " + station + " 정거장에 도착했습니다.");
    }
    void depart(){  // 출발
        System.out.println(busNumber + "번 버스가 " + station + " 정거장에서 출발합니다.");
    }
    void board(){   // 승객 탑승
        System.out.print(passenger + "(이)가 버스를 탑승합니다. ");
    }
    void pay(){     // 요금 지불
        System.out.println(passenger + "(이)가 " + pirce + "원을 지불합니다.");
    }

}
