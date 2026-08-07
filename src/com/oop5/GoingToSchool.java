package com.oop5;

// 객체를 사용하고 실행해보는 테스트 측 코드
public class GoingToSchool {
    public static void main(String[] args) {

        Student stu1 = new Student("홍길동", 10000);
        Student stu2 = new Student("이순신", 5000);

        // 버스
        Bus bus133 = new Bus(133);
        Bus bus57 = new Bus(57);
        stu1.takeBus(bus133);
        stu2.takeBus(bus133);

        stu1.studentInfo(); // 현재 소지금 확인
        stu2.studentInfo(); // 현재 소지금 확인
        System.out.println("-----------------");
        bus133.busInfo();

        // 지하철
        System.out.println("-----------------");
        Subway sub1 = new Subway(1);
        Subway sub2 = new Subway(2);

        stu1.takeSubway(sub1);
        stu1.takeSubway(sub2);
        sub1.subwayInfo();

        // 밥
        System.out.println("-----------------");

        Rice r1 = new Rice("볶음밥", 350);
        stu1.eatRice(r1);
        r1.riceInfo();
    }

}
