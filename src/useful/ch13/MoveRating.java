package useful.ch13;

import java.util.ArrayList;
import java.util.List;

public class MoveRating {

    public static void main(String[] args) {

        List<String> movies = new ArrayList<>();

        movies.add("범죄도시 - ****");
        movies.add("기생충 - *****");
        movies.add("어벤저스(엔드게임) - *****");
        movies.add("태권V - **");

        System.out.println("=== 전체 영화 목록 ===");
        for (int i = 0; i < movies.size(); i++) {
            System.out.println((i+1) + ". " + movies.get(i));
        }

        System.out.println("\n총 " + movies.size() + "편");

        // 삭제
        movies.remove(2);
        // movies.remove("어벤저스(엔드게임) - *****");    // 인덱스가 편함 - 공백포함 한 글자라도 다르면 안됨
        System.out.println(movies);
        System.out.println("\n삭제 후 총 " + movies.size() + "편");

        // 기생충 영화 여부 확인 - 공백포함 한 글자라도 다르면 안됨
        System.out.println("기생충 영화 존재 여부 확인: " + movies.contains("기생충 - *****"));

    }

}
