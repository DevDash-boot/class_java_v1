package ch02;

public class DataType4 {

    public static void main(String[] args) {

        // 기본 자료형(논리 자료형)
        // 사실을 관찰하고 결과값이 참, 거짓을 판별할 때 사용
        // 크기는 1byte이다.
        // 사실 1비트만으로도 참과 거짓의 데이터를 다룰 수 있다.
        // 하지만 비트라는 단위는 너무 작은 단위라서 컴퓨터가 연산을 비트 크기로 하게 되면 도로 연산이 느려진다.
        // 최소 컴퓨터 연산 단위가 1byte로 한다.

        boolean isMarried = false;
        System.out.println(isMarried);
        isMarried = true;
        System.out.println(isMarried);

        // 초기화
        boolean isOk;
        isOk = false;
        System.out.println(isOk);
        
        // 바로 값을 화면에 출력
        System.out.println(true);
        System.out.println(false);

    } // end of main
}  // end of class
