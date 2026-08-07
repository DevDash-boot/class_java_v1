package exercise;

import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력하세요: ");
        int maxNumber = scanner.nextInt();
        int sum = 0;

        // 1부터 사용자가 입력한 숫자까지의 모든 짝수의 합을 계산하는 프로그램
        for (int i = 0; i <= maxNumber; i++) {  // maxNumber까지 반복 수행
            if ((i % 2) == 0)  // i를 2로 나눈 나머지가 0이면 짝수, 1이면 홀수
                sum += i;  // if문을 충족하는 짝수가 sum에 더해진다. 입력한 maxNumber 수까지 계속 더해진다.
        }

        System.out.println("짝수의 합: " + sum);
        scanner.close();
    }  // end of main
    
} // end of class
