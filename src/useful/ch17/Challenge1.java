package useful.ch17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Challenge1 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> result = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .toList();

        System.out.println(result);

        // 도전과제 - Stream API를 사용하지 않고 만들어보기
        // 짝수만 골라서 어디에 담아야 한다면
        List<Integer> r2 = new ArrayList<>();
        System.out.println(r2.isEmpty());
        for (int n : numbers) {
            if (n % 2 == 0) {
                int square = n * n;
                r2.add(square);
            }
        }
        System.out.println(r2);
    }
}
