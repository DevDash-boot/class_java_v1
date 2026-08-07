package ch08;

import java.util.Scanner;

public class MenuChoice5 {

    public static void main(String[] args) {
        // 1, 2, 3, 4, 0 번을 상수로 선언하고 활용
        // C R U D : Create Read Update Delete
        //            생성   조회   수정   삭제
        // SQL문:    Insert Select Update Delete
        // 프로그램 종료 시 사용자가 1~4번 메뉴를 누른 횟수를 출력
        // CRUD
        // 변수 name을 사용해서 CRUD를 구현

        Scanner sc = new Scanner(System.in);
        final int CREATE = 1;
        final int READ = 2;
        final int UPDATE = 3;
        final int DELETE = 4;
        final int END = 0;
        String name = "";
        int count = 0; // 메뉴를 선택한 횟수 변수 초기화
        int errorCount = 0; // 0~4 범위를 벗어난 번호 입력 변수 초기화
        boolean insertName = true;

        while (true) {
            System.out.println("\n메뉴 선택");
            System.out.println("1. 등록  2.조회  3. 수정  4. 삭제  0. 종료");
            System.out.print("선택: ");

            int menu = sc.nextInt();
            sc.nextLine();  // 개행문자 소비

            // 메뉴를 선택한 횟수 증가
            if (menu >= 1 && menu <= 4) {
                count++;
            }

            // 0~4 범위를 벗어난 번호 입력 횟수 초기화
            if (menu >= 0 && menu <= 4) {
                errorCount = 0;
            }

            if (menu == CREATE) {
                // 만약 name에 등록된 값이 있다면 이미 등록되어 있습니다.
                // name 변수에 스캐너를 사용해서 이름을 등록하는 기능 구현
                if (!insertName) {
                    System.out.println("이미 등록되어 있습니다.");
                } else {
                    System.out.print("등록할 이름: ");
                    name = sc.nextLine();
                    System.out.println(name + "이 등록 되었습니다.");
                    insertName = false;
                }
            } else if (menu == READ) {
                // name 안에 담겨진 값을 출력하는 기능 구현
                // 만약 이름이 등록된 적이 없다면 조회할 이름이 없습니다. 출력
                if (insertName) {
                    System.out.println("조회할 이름이 없습니다.");
                } else {
                    System.out.println("조회된 이름: " + name);
                }
            } else if (menu == UPDATE) {
                // name 을 수정하는 기능 구현
                if(insertName) {
                    System.out.println("수정할 이름이 없습니다.");
                }else{
                    System.out.print("수정할 이름: ");
                    name = sc.nextLine();
                    System.out.println("수정 되었습니다.");
                }
            } else if (menu == DELETE) {
                // name 을 삭제하는 기능 구현
                if (insertName){
                    System.out.println("삭제할 이름이 없습니다");
                }
                else{
                    name = "";
                    System.out.println("삭제되었습니다.");
                    insertName = true;
                }
            } else if (menu == END) {
                System.out.println("프로그램을 종료합니다.");
                System.out.println("메뉴를 " + count + "번 선택했습니다.");
                break;
            } else {
                System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                // 0~4 범위를 벗어나는 번호를 입력할 경우 횟수 증가
                // 3회 이상이 되면 강제 종료
                errorCount++;
                if (errorCount >= 3) {
                    System.out.println("프로그램을 강제 종료합니다.");
                    break;
                }
            }
        }
    } // end of main
} // end of class