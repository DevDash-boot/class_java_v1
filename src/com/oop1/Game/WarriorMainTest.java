package com.oop1.Game;

public class WarriorMainTest {
    // 코드 실행의 시작점 - JVM - Stack
    public static void main(String[] args) {
        // Warrior w1 // Warrior 변수 선언
        // new = 키워드, () = 생성자 호출
        Warrior w1 = new Warrior();

        w1.name = "김전사";
        w1.level = 7;
        w1.health = 120;
        w1.attackPower = 48;
        w1.defensePower = 34;
        w1.height = 177.3;

        // w1 참조 변수에 접근해서 값을 할당해보자
        // 객체의 접근은 .연산자로 할 수 있다.
        System.out.println("w1의 주소값: " + w1);
        System.out.println("이름: " + w1.name);
        System.out.println("레벨: " + w1.level);
        System.out.println("체력: " + w1.health);
        System.out.println("공격력: " + w1.attackPower);
        System.out.println("방어력: " + w1.defensePower);
        System.out.println("키: " + w1.height);
        System.out.println("===========================");

        // Warrior 타입의 객체를 생성해서 해당하는 상태 값을 입력하고 출력
        Warrior w2 = new Warrior();
        w2.name = "전사2";
        w2.level = 16;
        w2.health = 230;
        w2.attackPower = 72;
        w2.defensePower = 51;
        w2.height = 180.1;

        System.out.println("이름: " + w2.name);
        System.out.println("레벨: " + w2.level);
        System.out.println("체력: " + w2.health);
        System.out.println("공격력: " + w2.attackPower);
        System.out.println("방어력: " + w2.defensePower);
        System.out.println("키: " + w2.height);

    } // end of main
} // end of main