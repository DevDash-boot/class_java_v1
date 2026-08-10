package useful.ch15;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordBook {
    public static void main(String[] args) {
        // apple -> 사과 형식의 저장, 수정, 삭제, 조회
        Map<String, String> words = new HashMap<>();

        Scanner sc = new Scanner(System.in);

        words.put("apple", "사과");
        words.put("banana", "바나나");
        words.put("cherry", "체리");

        while(true){
            System.out.println("\n===== 영한 단어장 =====");
            System.out.println("1. 단어 추가 2. 단어 검색 3. 전체 출력 4. 종료");
            System.out.print("선택: ");
            int choice = sc.nextInt();
            sc.nextLine();

            // 아래 기능을 구현
            // 1. 추가
            if (choice == 1) {
                System.out.print("영어 단어 : ");
                String engWords = sc.nextLine();

                System.out.print("한글 : ");
                String korWords = sc.nextLine();

                words.put(engWords, korWords);
                System.out.println("추가되었습니다.");
            }
            // 2. 검색
            else if(choice == 2){
                System.out.print("영어로 단어 검색 : ");
                String search = sc.nextLine();

                if(words.containsKey(search)){
                    System.out.println("검색 : " + words.get(search));
                }
                else {
                    System.out.println("찾을 수 없습니다.");
                }
            }
            // 3. 전체 출력
            else if (choice == 3) {
                System.out.println("\n[전체 출력]");
                for(String all : words.keySet()){
                    System.out.println(words.get(all));
                }
            }
            // 4. 종료
            else if(choice == 4){
                System.out.println("종료");
                break;
            }
        }

    }
}
