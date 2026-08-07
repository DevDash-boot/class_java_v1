package ch08;

import java.util.Scanner;

public class BreakTest2 {

    public static void main(String[] args) {
        // 1. 1부터 100까지 반복문 진행
        // 2. 3의 배수만 화면에 출력
        // 3. 50 이상이면 반복문을 종료
        // 4. for문 이용

        Scanner sc = new Scanner(System.in);
        System.out.print("수 입력: ");
        int max = sc.nextInt();

        System.out.println("for문");
        for (int i = 1; i <= max; i++) {
            if ((i % 3 == 0) && (i % 4 == 0)) {
                System.out.print(i + " ");
            }
            if (i >= 100) {
                break;
            }
        }
        System.out.println();
        System.out.println("while문");
        int a = 1;
        while(a <= max){
            if ((a % 3 == 0) && (a % 4 == 0)) {
                System.out.print(a + " ");
            }
            if (a >= 123) {
                break;
            }
            a++;
        }

    } // end of main

} // end of class
