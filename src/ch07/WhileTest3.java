package ch07;

import java.util.Scanner;

public class WhileTest3 {
    public static void main(String[] args) {
        // 1. 1 + ... + 10 = 55
        // 2. 끝 값을 스캐너를 통해 연산 코드를 작성
        Scanner sc = new Scanner(System.in);
        System.out.print("마지막 값을 입력하시오: ");
        int start = 1, sum = 0;
        int end = sc.nextInt();

        while(start <= end){
            sum += start;
            start++;
        }
        System.out.println("총 합계 : " + sum);

    } // end of main
} // end of class
