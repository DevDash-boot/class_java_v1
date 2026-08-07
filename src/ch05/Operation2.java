package ch05;

public class Operation2 {

    public static void main(String[] args) {

        System.out.println(5 + 3);
        System.out.println(5 - 3);
        System.out.println(5 * 3);
        System.out.println(5 / 3);  //  결과가 1인 이유 -> int로 떨어지는 소수점은 버려짐
        System.out.println(5 / (double)3);
        System.out.println(5 % 3);

        // 문제 1. (12 + 3) / 3 을 화면에 출력. 단, 결과값을 변수에 담아서 출력
        double r1 = (double) (12 + 3) / 3 ;
        System.out.println("(12 + 3) / 3 = " + r1);

        // 문제 2. (25 % 2) 값을 화면에 출력
        int r2 = 25 % 2;
        System.out.println("25 % 2 = " + r2);
        // 나머지 연산자는 해당하는 값이 홀수인지 짝수인지 판별할 때 유용하다.
        // 어떤 수를 2로 나누었을 때 나머지가 0이면 짝수이고, 1이면 홀수라고 판별됨

        // 문제 3. 7896456 값이 홀수인지 짝수인지 화면에 1 또는 0으로 출력
        int r3 = 7896456 % 2;
        System.out.println("7896456 % 2 = " + r3);

    } // end of main
}   // end of class
