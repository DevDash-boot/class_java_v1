package ch07;

public class ForTest2 {

    public static void main(String[] args) {
        // 화면에 구구단 2단을 출력하시오

        // for문 없이 구구단 2단을 출력했을 때
        int num = 2;
        System.out.println(num + " * 1 = " + (num * 1));
        System.out.println(num + " * 2 = " + (num * 2));
        System.out.println(num + " * 3 = " + (num * 3));
        System.out.println(num + " * 4 = " + (num * 4));
        System.out.println(num + " * 5 = " + (num * 5));
        System.out.println(num + " * 6 = " + (num * 6));
        System.out.println(num + " * 7 = " + (num * 7));
        System.out.println(num + " * 8 = " + (num * 8));
        System.out.println(num + " * 9 = " + (num * 9));
        System.out.println("-----------------------");

        // 단을 변수 없이 정수로 입력했을 때
        for (int g = 1; g < 10; g++)
            System.out.println("3 * " + g + " = " + (3 * g));
        System.out.println("-----------------------");

        // 단 자리에 변수를 주었을 때
        for (int g = 1; g < 10; g++)
            System.out.println(num + " * " + g + " = " + (num * g));
        System.out.println("-----------------------");

        // 이중 for문을 활용하여 구구단을 출력
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.println(i + " * " + j + " = " + i * j);
            }
            System.out.println();

        }
    } // end of main

}   // end of class
