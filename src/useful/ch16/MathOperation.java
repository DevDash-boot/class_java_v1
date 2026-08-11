package useful.ch16;

@FunctionalInterface
public interface MathOperation {
    int operate(int x, int y);  // 정수값 2개를 받는 추상 메서드
    // void run();
}
