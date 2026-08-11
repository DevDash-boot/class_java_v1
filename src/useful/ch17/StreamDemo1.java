package useful.ch17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamDemo1 {
    public static void main(String[] args) {
        // 나이 목록에서 18세 이상만 선택하는 코드를 2가지 방법으로 알아보자

        // int[] arr = {1,2,3};
        List<Integer> ages = Arrays.asList(20, 11, 18, 24, 30, 42, 5);
        List<Integer> adultAges1 = new ArrayList<>();
        // 방법 1. 지금까지 배운 방식
        for (int age : ages) {
            if(age >= 18){
                adultAges1.add(age);
            }
        }
        System.out.println("for문 방식 : " + adultAges1);

        // 방법 2. Stream 방식
        // 오직 함수형 인터페이스 안에 추상메서드의 매개변수가 하나라면 소괄호도 생략 가능
        List<Integer> adultAges2 = ages
                .stream()
                .filter(age -> age >= 18)
                .toList();  // 최종 연산 필요(여기서는 toList())

        System.out.println("Stream 방식 : " + adultAges2);
    }
}
