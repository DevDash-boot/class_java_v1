package useful.ch02;

public class SubStringMain {
    public static void main(String[] args) {

        // substring : 문자열의 일부 구간을 잘라내어 새로운 문자열로 반환하는 메서드

        String a = "Hello World!";

        // 1. 시작 위치부터 끝까지 자르기
        System.out.println(a.substring(2));

        // 2. 시작 위치부터 끝 위치 앞까지
        System.out.println(a.substring(0,7));

        System.out.println(a.substring(-1));

    }
}
