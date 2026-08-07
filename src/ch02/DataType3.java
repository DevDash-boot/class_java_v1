package ch02;

public class DataType3 {

    public static void main(String[] args) {
        // 기본 자료형(실수형)
        // 1.0, 0.123...
        // float(4바이트), double(8바이트)

        // 4바이트 상자에 8바이트 크기를 넣으려니 오류 발생
        // 접미사 f 선언 필요 -> 실수형의 기본 연산 단위는 double 타입이다.
        // 접미사를 사용해서 자바(컴파일러)에게 0.5는 double이 아니라 float 타입이라고 명시
        float floatBox1 = 0.5f;
        float floatBox2 = 0.5F;

        // 실수형 자료에서 기본 연산 단위는 double 타입이다.
        // 왜 더 큰  8byte를 기본 연산으로 사용할까? -> 값의 정확성 때문에 사용
        double doubleBox1 = 0.123;
        double doubleBox2 = 0.5;

    }  // end of main
} // end of class
