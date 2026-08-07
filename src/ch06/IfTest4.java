package ch06;

import java.util.Scanner;   // Scanner 클래스 import

public class IfTest4 {
    public static void main(String[] args) {
        // 키보드에서 값을 받을 도구 준비
        Scanner sc = new Scanner(System.in);
        System.out.println("성적을 입력하세요.");

        int grade = sc.nextInt();
        System.out.println("성적 : " + grade);

        char result;

        // 조건문을 사용해서 입력받은 값에 따라 학점을 출력하는 프로그램
        // 사용자가 값을 잘못 입력하는 경우 방어적 코드를 작성
        // 0 ~ 100점 사이값만 받을 예정
        if (grade < 0 || grade > 100) {
            System.out.println("잘못된 입력입니다. 다시 프로그램을 실행하세요.");
            return; // 실행의 제어권을 반납
        }
        if (grade >= 90)
            result = 'A';
        else if (grade >= 80)
            result = 'B';
        else if (grade >= 70)
            result = 'C';
        else if (grade >= 60)
            result = 'D';
        else
            result = 'F';

        System.out.println("당신의 학점은 " + result + " 입니다.");

    } // end of main

} // end of class
