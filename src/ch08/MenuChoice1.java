package ch08;

import java.util.Scanner;

public class MenuChoice1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 1, 2, 3, 4, 0 번을 상수로 선언하고 활용
        // C R U D : Create Read Update Delete
        //            생성   조회   수정   삭제
        // SQL문:    Insert Select Update Delete
        final int CREATE = 1;
        final int READ = 2;
        final int UPDATE = 3;
        final int DELETE = 4;
        final int END = 0;

        while(true) {
            System.out.println("메뉴 선택");
            System.out.println("1. 등록  2.조회  3. 수정  4. 삭제  0. 종료");
            System.out.print("선택: ");
            int menu = sc.nextInt();

            if (menu == CREATE) {
                System.out.println("등록을 선택했습니다.\n");
            } else if (menu == READ) {
                System.out.println("조회를 선택했습니다.\n");
            } else if (menu == UPDATE) {
                System.out.println("수정을 선택했습니다.\n");
            } else if (menu == DELETE) {
                System.out.println("삭제를 선택했습니다.\n");
            } else if (menu == END) {
                System.out.println("프로그램을 종료합니다.\n");
                break;
            } else {
                System.out.println("잘못된 입력입니다. 다시 선택해주세요.\n");
            }
        }

    } // end of main

} // end of class
