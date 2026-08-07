package useful.ch04;

public class ThrowHandling {
    public static void main(String[] args) {

        Calc calc = new Calc();
        try {
            calc.divide(100, 0);
        } catch (Exception e) {
            System.out.println("어떤 수를 0 으로 나눌 수 없습니다.");
        }

    }
}

// Calc 클래스 설계
class Calc {

    // throws (메서드 선언부에서 사용) : 예외 처리를 사용하는 사람이 직접 다룰 수 있도록 던질 수 있다.
    // 강제성이 발생 됨 - 사용하는 측에서 반드시 처리를 해야하는 강제성이 생성됨
    public int divide(int n1, int n2) throws DivideByZeroException{
        System.out.println("나누기 동작");
        return n1 / n2;
    }
}