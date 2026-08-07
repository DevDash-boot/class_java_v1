package useful.ch03;

public class StringTest1 {

    public static void main(String[] args) {
        String s1 = "aaa";  // 불변
        String s2 = "aaa";  // String Pool에 값이 있다면 새로 만들지 않는다.

        // 하지만 new String을 하면 새로 값을 만들기 때문에 String Pool을 참조하지 않는다.
        String s3 = new String("aaa");  // 불변
        String s4 = new String("aaa");

        // 메모리 위치 특성 때문에 값이 다르게 나온다.
        // == 은 주소값을 비교한다.
        System.out.println("s1 == s2 : " + (s1 == s2)); // true
        System.out.println("s3 == s4 : " + (s3 == s4)); // false

        // Object 의 equals() 기본 동작은 주소값 비교이지만,
        // String 의 equals()는 내부적으로 재정의 되어 있어 "문자열 내용"을 비교한다.
        // 즉 논리적 동등성 비교함
        // 결론 : 문자열을 논리적으로 비교할 때 무조건 == 대신 equals()를 사용해야 한다.
        System.out.println("s3.equals(s1) : " + s3.equals(s1)); //true
        System.out.println("s3.equals(s4) : " + s3.equals(s4)); //true

        s1 += "a";
    }
}
