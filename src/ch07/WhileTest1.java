package ch07;

public class WhileTest1 {
    public static void main(String[] args) {
        int i = 1;

        // 무한 루프를 조심
        while (i <= 10) {
            System.out.println("i 값 : " + i);
            // 조건식에 대한 처리가 없다면 무한히 반복
            i++; // 11에 도달하면 조건식이 false가 되서 종료가 된다.
        }

        System.out.println("---------------");
        int num = 1, sum = 0;
        while (num <= 10) {
            sum += num;
            num++;  // 조건식에 대한 처리
        }
        System.out.println("합계: " + sum);

    } // end of main
} // end of class
