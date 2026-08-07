package ch08;

import java.util.Scanner;

public class MenuChoice3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 잘못된 입력을 3회 이상 입력시 강제 종료
        // 단, 3회 이전에 제대로 된 메뉴를 선택했다면 다시 0으로 초기화

        final int CREATE = 1;
        final int READ = 2;
        final int UPDATE = 3;
        final int DELETE = 4;
        final int END = 0;

        int count = 0;

        while (true) {
            System.out.println("메뉴 선택");
            System.out.println("1. 등록  2.조회  3. 수정  4. 삭제  0. 종료");
            System.out.print("선택: ");
            int menu = sc.nextInt();

            // 횟수 초기화
            if (menu >= 0 && menu <= 4) {
                count = 0;
            }

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
                // 0~4 범위를 벗어나는 번호를 입력할 경우 횟수 증가
                // 3회 이상이 되면 강제 종료
                count++;
                if (count >= 3) {
                    System.out.println("프로그램을 강제 종료합니다.");
                    break;
                }
                System.out.println("잘못된 입력입니다. 다시 선택해주세요.\n");
            }
        sc.close();
        }

    } // end of main

} // end of class
