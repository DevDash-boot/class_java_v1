package ch05;

public class Operation6 {
    public static void main(String[] args) {

        // 논리 연산자(&&, ||, !)
        int num1 = 100, num2 = 200;

        // 1. 논리곱(&&)
        //                  true   &&   true  --> true
        boolean flag1 = (num1 > 0) && (num2 > 0);
        System.out.println("flag1 : " + flag1);
        //                  true   &&   false  --> false
        boolean flag2 = (num1 > 0) && (num2 < 0);
        System.out.println("flag2 : " + flag2);
        System.out.println("-------------------------");

        // 2. 논리합(||)
        //                  true   &&   true  --> true
        boolean flag3 = (num1 > 0) || (num2 > 0);
        System.out.println("flag3 : " + flag3);
        //                  false   &&   true  --> true
        boolean flag4 = (num1 < 0) || (num2 > 0);
        System.out.println("flag4 : " + flag4);
        //                  false   &&   false  --> false
        boolean flag5 = (num1 < 0) || (num2 < 0);
        System.out.println("flag5 : " + flag5);
        System.out.println("-------------------------");

        // 3. 부정 논리 연산자(!)
        System.out.println(!true); // false
        System.out.println(!false); // true

    }  // end of main

}   // end of class
