package ch05;

/*
 * 관계(비교) 연산자
 * 연산의 결과는 true 또는 false로 반환된다.
 */

public class Operation5 {
    public static void main(String[] args) {
        int num1 = 5, num2 = 3;
        boolean result1 = num1 > num2;
        System.out.println("result1 = " + result1); //true
        System.out.println(num1 > num2); // true
        System.out.println(num1 < num2); // false
        System.out.println(num1 >= num2); // true
        System.out.println(num1 <= num2); // false
        System.out.println(num1 == num2); // false
        System.out.println(num1 != num2); // true

    }  // end of main

}   // end of class
