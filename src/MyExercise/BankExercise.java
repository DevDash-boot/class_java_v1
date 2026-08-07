package MyExercise;

import java.util.Scanner;

public class BankExercise {

    public static void main(String[] args) {

        // 변수 선언
        final int DEPOSIT = 1, WITHDRAW = 2, BALANCE = 3, EXIT = 0; // 입금, 출금, 잔액조회, 종료
        int balance = 0; //초기 잔액
        int money; // 금액
        int sum = 0; // 잔액
        int deCount = 0; // 입금 거래 횟수
        int wiCount = 0; // 출금 거래 횟수

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n======= 은행 ATM 자금 관리 프로그램 =======");
            System.out.println("1. 입금   2. 출금   3. 잔액 조회    0. 종료");
            System.out.print("번호를 선택해 주세요: ");

            int number = sc.nextInt(); // 입력된 번호

            // 1, 2, 3, 0 외 잘못된 번호를 입력한 경우
            if(number >3 || number <0){
                System.out.println("잘못된 번호를 입력했습니다. 다시 입력해주세요.");
            }

            // 입금
            if (number == DEPOSIT) {
                System.out.print("입금할 금액: ");
                money = sc.nextInt(); // 입금할 금액 입력
                sc.nextLine(); // sc.nextInt()문 뒤에 엔터부분을 추가해서 개행 문자 소비
                if (money <= 0) {
                    System.out.println("0원은 입금할 수 없습니다.");
                }else {
                    sum += money; // 잔액에 더하기
                    deCount++; // 입금 거래 횟수
                    System.out.println(money + "원 입금되었습니다. 현재 잔액은 " + sum + "원 입니다.");
                }
            }
            // 출금
            else if (number == WITHDRAW) {
                System.out.print("출금할 금액: ");
                money = sc.nextInt(); // 출금할 금액 입력
                sc.nextLine(); // sc.nextInt()문 뒤에 엔터부분을 추가해서 개행 문자 소비
                if (money <= 0) {
                    System.out.println("0원 이하의 금액은 출금할 수 없습니다.");
                }else if (sum < money) {
                    System.out.print("잔액의 범위를 초과합니다. 현재 잔액은 " + sum + "입니다.\n");
                }else{
                    sum -= money; // 잔액에서 빼기
                    wiCount++; // 출금 거래 횟수
                    System.out.println(money + "원 출금했습니다. 현재 잔액은 " + sum + "원 입니다.");
                }
            }
            // 잔액 조회
            else if (number == BALANCE) {
                System.out.println("현재 잔액은 " + sum + "원입니다.");
            }
            // 종료
            else if (number == EXIT) {
                System.out.println("입금은 " + deCount + "번, " + "출금은 " + wiCount + "번 거래 되었습니다.");
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
        sc.close();
    } // end of main
} // end of class
