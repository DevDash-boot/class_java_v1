package useful.ch16;

@FunctionalInterface
interface Comparsion {
    int operate(int x, int y);  // 정수값 2개를 받는 추상 메서드
}

public class Practice1 {
    public static void main(String[] args) {

        Comparsion c = (int x, int y) -> x > y ? x : y;
        System.out.println(c.operate(10, 5));
        System.out.println(c.operate(10, 50));

    }
}
