package com.oop7;

import java.util.Scanner;

// 코드를 실행해 보는 측
public class GoingToSchoolMenu {
    public static void main(String[] args) {

        // 준비물
        Scanner sc = new Scanner(System.in);
        final int EAT = 1;
        final int BUS = 2;
        final int SUBWAY = 3;
        final int MY_INFO = 4;
        final int END = 0;

        System.out.print("학생의 이름을 입력하세요: ");
        String name = sc.nextLine();

        int riceMenu = 0;

        // 객체 생성(등장인물 준비)
        Student stu1 = new Student(name, 10000);
        Rice rice1 = new Rice(riceMenu, 3000);
        Bus bus133 = new Bus(133, 0);
        Subway line1 = new Subway(1, 0);

        while (true) {
            System.out.println();
            System.out.println("== 메뉴 선택==");
            System.out.println("1.밥 먹기 2.버스 타기 3.지하철 타기 4.내 상태 0. 종료");

            // 직접 실행 흐름 만들어 보기

            int menu = sc.nextInt();    // 메뉴 선택
            sc.nextLine();  // 개행문자 소비

            if (menu == EAT) { // 1번 메뉴
                System.out.println("1. 김치볶음밥, 2.라면, 3.김밥 중 메뉴를 선택하세요.");
                int rmn = sc.nextInt();
                stu1.eatRice(rice1, rmn);
            } else if (menu == BUS) { // 2번 메뉴
                stu1.takeBus(bus133);
                bus133.busInfo();
            } else if (menu == SUBWAY) { // 3번 메뉴
                stu1.takeSubway(line1);
                line1.subwayInfo();
            } else if (menu == MY_INFO) { // 4번 메뉴
                stu1.studentInfo();
            } else if (menu == END) { // 0번 메뉴
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
            }
        }

    } // end of main
}
