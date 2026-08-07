package ch07;

public class ForTest3 {

    public static void main(String[] args) {
        // 1부터 100 까지 수 중 홀수의 총 합을 구하시오
        //
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0) {
                sum += i;
            }
        }
        System.out.println("총 합계: " + sum+ "\n");

        // 반복문에 증감식을 2씩 증가
        for (int i = 0; i < 10; i += 2) {
            System.out.println("2씩 증가 + " + i);
        }
        System.out.println();

        // 화면에 10 ~ 1을 출력하는 코드
        for (int i = 10; i>0 ; i--){
            System.out.printf(i + " ");
        }
        System.out.println();


    } // end of main
}   // end of class
