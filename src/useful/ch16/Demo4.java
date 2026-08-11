package useful.ch16;

public class Demo4 {
    public static void main(String[] args) {
        // 단계적으로 줄여쓰기

        // 1단계 : 매개변수 타입 생략 가능
        MathOperation add = (x, y) -> {return x + y;};

        // 2단계 : 중괄호와 리턴 타입 생략
        MathOperation sub = (x, y) ->  x - y;

        // 주의 : 만약 여러줄이 필요하다면 중괄호와 return 은 그대로 사용한다.
        MathOperation div = ( x, y) -> {
            if(y == 0){
                System.out.println("0으로 나눌 수 없습니다.");
                return 0;
            }
            return x / y;
        };

        System.out.println(add.operate(10,5));
        System.out.println(sub.operate(10,5));
        System.out.println(div.operate(10,5));
    }
}