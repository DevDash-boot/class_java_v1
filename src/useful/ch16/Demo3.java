package useful.ch16;

// 자바 API에서 제공해주는 함수형 인터페이스 말고
// 내가 직접 설계하고 싶다면 함수형 인터페이스를 만들어야 한다.

// @FunctionalInterface 은 인터페이스 안에 단 하나의 추상 메서드를 가질 수 있도록 강제한다.
//@FunctionalInterface
//interface MathOperation {
//    int operate(int x, int y);  // 정수값 2개를 받는 추상 메서드
//    // void run();
//}

public class Demo3 {
    public static void main(String[] args) {
        // 함수형 인터페이스 타입에 람다식을 담을 수 있다.
        MathOperation add = (int x, int y) -> {return x + y;};
        MathOperation sub = (int x, int y) -> {return x - y;};
        MathOperation mul = (int x, int y) -> {return x * y;};
        MathOperation div = (int x, int y) -> {return x / y;};

        // 주의 : 호출할 때는 참조변수의 이름이 아니라 인터페이스에 정의된 메서드 이름을 호출해야 동작한다.
        System.out.println("10 + 5 = " + add.operate(10, 5));
        System.out.println("10 - 5 = " + sub.operate(10, 5));
        System.out.println("10 * 5 = " + mul.operate(10, 5));
        System.out.println("10 / 5 = " + div.operate(10, 5));
    }
}
