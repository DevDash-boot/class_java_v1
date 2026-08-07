package ch06;

public class IfTest1 {
    public static void main(String[] args) {
        // 만약 ... 라면 -> if(조건문){...}
        // 주어진 조건에 따라서 실행이 다르게 이루어지도록 구현할 수 있다.

        boolean flag = true;

        // 단독 if문
        // 수행 구문이 실행될 수도 있고 실행되지 않을 수도 있다.
        if (flag) {
            // 수행 구문
            System.out.println("주어진 식이 true 이면 실행됨");
        }   // end of if

        System.out.println("프로그램을 종료합니다.");

    } // end of main
} // end of class
