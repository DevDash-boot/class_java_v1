package useful.ch16;

public class Demo1 {
    public static void main(String[] args) {
        // 1. 람다 표현식에 대해 알아보자
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("작업자가 해야 할 일 정의");
            }
        }).start();

        // 2. 위 코드를 람다 표현식으로 사용
        new Thread(() -> System.out.println("여기도 작업자가 해야 할 일 정의")).start();

        // 3. 자바 컴파일러는 타입 추론이 가능하다
        // -> : 매개변수와 메서드를 구분하는 것
        // Runnable 안에는 void run 밖에 없기 때문에 간소화가 가능하다.
        new Thread(() -> System.out.println("작업자가 해야 할 일 정의")).start();

        // var <- 요즘에 허용해 주는 문법
    }
}
