package ch05;
/*
* 부호 연산자
* 단항 연산자, 변수에 부호를 변경한다.
* 단, 변수 안에 들어가 있는 값의 부호를 변경하려면 대입 연산자와 함께 사용해야 한다.
*/
public class Operation1     {
    public static void main(String[] args) {

        int iData = 100;
        System.out.println(+iData);
        System.out.println(-iData);
        System.out.println("-------------");
        // 부호 연산자는 실제 변수의 값을 변경하는 개념은 아니다.
        System.out.println("iData : " + iData);

        // 실제 변수의 값을 변경하기 위해서는 대입 연산자와 함께 사용해주어야 한다.
        iData = -iData; // 부호 연산자를 사용해서 새로 대입하는 개념
        System.out.println("iData : " + iData);

    }  // end of main

}   // end of class
