package useful.ch03;

public class StringTest2 {

    public static void main(String[] args) {
        String s1 = new String("Hello");
        String s2 = new String("World");
        Dog dog = new Dog();
        System.out.println(dog);    // 주소값
        System.out.println(s1);     // toString으로 재정의

        // String의 실제 주소값을 확인해보자.
        // System.identityHashCode(s1)을 이용해 해시코드 값 확인가능
        System.out.println(System.identityHashCode(s1));

        // 문자열은 불변이다. - 한번 생성된 문자열은 불변이고 변경이 발생되면 새로 문자열이 생성되는 구조이다.
        s1 += " World";
        System.out.println("s1 + World : " + s1);
        System.out.println(System.identityHashCode(s1));

        s2 = s2.concat("Hello");
        System.out.println(s2);

    }
}

class Dog{}
