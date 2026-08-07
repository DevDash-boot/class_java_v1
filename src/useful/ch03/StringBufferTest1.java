package useful.ch03;

public class StringBufferTest1 {
    public static void main(String[] args) {
        String str1 = new String("Hello");
        String str2 = new String("World");

        // 1. StringBuffer 사용하는 방법
        StringBuffer buffer1 = new StringBuffer(str1);
        System.out.println(buffer1);    // Hello
        System.out.println(System.identityHashCode(buffer1));   // 189568618

        // 2. 문자열을 더하기 해보자.
        buffer1.append(str2);
        System.out.println(buffer1);    // HelloWorld
        System.out.println(System.identityHashCode(buffer1));   // 189568618

        // 3. StringBuffer -> String 으로 형 변환하는 방법
        String str3 = buffer1.toString();   // toString() 호출 시 String 타입으로 변환됨

        // 결론
        // StringBuffer를 사용하면 새 객체를 만들지 않고 내부 상태값을 바꾸기 때문에 메모리 낭비를 막을 수 있다.
        // 즉, 문자열을 많이 변경하는 로직이라면 StringBuffer를 사용하는 것이 좋다.(채팅어플)
    }
}
