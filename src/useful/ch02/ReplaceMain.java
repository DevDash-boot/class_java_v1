package useful.ch02;

public class ReplaceMain {
    public static void main(String[] args) {
        // replace : 문자열 안에서 특정 문자나 문자열을 찾아 다른 값으로 바꾼 새로운 문자열을 반환하는 메서드
        // 1. 원본은 절대 바뀌지 않습니다.
        // 2. 일치하는 부분을 전부 바꿉니다.
        // 3. 두 가지 메서드 오버로딩이 존재한다.

        // char 하나를 다른 char로 바꾸기
        String fruit = "Banana";
        String r1 = fruit.replace('a', 'O');
        System.out.println("결과: " + r1 + " 원본: " + fruit);

        // 문자열 단위로 바꾸기
        String phone = "010-1234-1234";
        String r2 = phone.replace("-", ".");
        System.out.println("결과: " + r2);

        // 활용
        String sentance = "자바는 재미있다. 또는 어렵기도 하다.";
        String r3 = sentance.replace("자바", "java");
        System.out.println("결과: " + r3);
    }
}
