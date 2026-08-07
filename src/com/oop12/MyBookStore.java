package com.oop12;

/*모든 프로그래밍의 기본은 C R U D 이다.
 * 배열을 활용한 간단한 데이터 관리 시스템
 */

import java.util.Scanner;

public class MyBookStore {
    // 현재 저장된 실제 데이터 개수를 추적하는 공유 변수(static)
    static int lastIndexNumber = 0;

    // 저장 기능(C)
    public static void save(Scanner sc, Book[] books) { // 받을 값을 괄호에 넣는다.
        System.out.println(">> 저장하기 호출 됨 <<");
        // 책 공간이 다 찼을 경우
        if (lastIndexNumber >= books.length) {
            System.out.println("저장 공간이 가득 찼습니다.\n");
            return;
        }

        System.out.print("책의 제목을 입력하세요: ");
        String title = sc.nextLine();
        System.out.print("책의 저자를 입력하세요: ");
        String author = sc.nextLine();

        Book book = new Book(title, author);    // 주소값에 담기
        books[lastIndexNumber] = book;          // 빈 배열 공간에 차례대로 저장하기
        lastIndexNumber++;
    }

    // 수정 기능(U)
    public static void update(Scanner sc, Book[] books) {
        System.out.print("수정할 책 제목을 입력해주세요: ");
        String targetTitle = sc.nextLine();

        boolean isFine = false; // 탐색되지 않는다면 false, 찾은 경우 false
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                // 문자열 비교는 반드시 equals()사용
                // .trim() : 문자열의 앞 뒤 공백 자동 제거(중간 공백은 제거되지 않음)
                if (books[i].getTitle().equals(targetTitle.trim())) {
                    System.out.println("[검색 결과 확인]");
                    books[i].showInfo();

                    System.out.print("수정할 책 제목: ");
                    String newTitle = sc.nextLine();
                    books[i].setTitle(newTitle);

                    System.out.print("수정할 저자: ");
                    String newAuthor = sc.nextLine();
                    books[i].setAuthor(newAuthor);

                    books[i].showInfo();
                    System.out.println();
                    isFine = true;
                    break;
                }
            }
        }
        // isFine -> true of false
        // isFine -> true / !isFine -> false
        // 단독 if문은 true일때 실행되니
        // if(!isFine) 이랑 같다
        if (isFine == false) {
            System.out.println("수정할 책이 없습니다.\n");
        }
    }

    // 전체 조회 기능(R)
    public static void readAll(Book[] books) {
        System.out.println(">> 전체 조회 호출 됨 <<");

        boolean isFine = false;

        // 저장된 책이 없는 경우
        if (lastIndexNumber == 0) {
            System.out.println("아직 저장된 책이 없습니다.");
            return;
        }

        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                System.out.println(books[i].getTitle() + ", " + books[i].getAuthor());
                isFine = true;
            }
        }
    }

    // 선택 조회 기능
    public static void searchByTitle(Scanner sc, Book[] books) {
        System.out.println(">> 선택 조회 호출 됨 <<");
        System.out.println("조회할 책 제목을 입력해주세요: ");
        String targetTitle = sc.nextLine();

        boolean isFine = false; // 탐색되지 않는다면 false, 찾은 경우 false
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                // 문자열 비교는 반드시 equals()사용
                // .trim() : 문자열의 앞 뒤 공백 자동 제거(중간 공백은 제거되지 않음)
                if (books[i].getTitle().equals(targetTitle.trim())) {
                    System.out.println("[검색 결과 확인]");
                    books[i].showInfo();
                    System.out.println();
                    isFine = true;
                    break;
                }
            }
        }
        // isFine -> true of false
        // isFine -> true / !isFine -> false
        // 단독 if문은 true일때 실행되니
        // if(!isFine) 이랑 같다
        if (isFine == false) {
            System.out.println("조회된 책이 없습니다.\n");
        }
    }

    // 전체 삭제 기능(D)
    public static void deleteAll(Book[] books) {
        System.out.println(">> 전체 삭제 호출 됨 <<\n");
        for (int i = 0; i < books.length; i++) {
            books[i] = null;
        }
        lastIndexNumber = 0;
    }

    // 선택 삭제 기능
    public static void searchDelete(Scanner sc, Book[] books) {
        System.out.println(">> 선택 삭제 호출 됨 <");
        if (lastIndexNumber == 0) {
            System.out.println("삭제할 책이 없습니다.");
        }
        // 1. 삭제할 책의 위치(인덱스)를 먼저 찾는다
        System.out.print("삭제할 책 제목을 입력하세요: ");
        String targetTitle = sc.nextLine().trim();  // 입력받는 동시에 공백 제거

        int targetIndex = -1; // -1은 못 찾았다는 뜻으로 약속한 값

        for (int i = 0; i < lastIndexNumber; i++) {
            if (books[i] != null && books[i].getTitle().equals(targetTitle)) {
                targetIndex = i;
                break;
            }
        }
        // 2. 책의 위치를 못 찾았으면 여기서 동작 끝
        if (targetIndex == -1) {
            System.out.println("해당 제목의 책을 찾을 수 없습니다.\n");
            return;
        }

        System.out.println("[삭제대상]");
        books[targetIndex].showInfo();
        System.out.println(targetTitle + " 책이 삭제되었습니다.\n");

        // 3. 삭제할 자리 뒤에 있는 요소들을 한 칸씩 앞으로 당겨서 삭제할 대상 덮어쓰기
        for (int i = targetIndex; i < lastIndexNumber - 1; i++) {
            books[i] = books[i + 1];  // i의 1칸 뒤의 것이 i의 자리로 덮어쓰기
        }
        // 4. 맨 뒤 칸을 비우고 실제 개수를 하나 줄인다(라스트 인덱스 번호 재경신)
        books[lastIndexNumber - 1] = null;
        lastIndexNumber--;  // 관리하고 있는 번호 -1

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Book[] books = new Book[100];

        // 샘플 데이터 만들어 놓기(값 사라지는 것 방지)
        books[0] = new Book("플러터UI실전", "김근호");
        books[1] = new Book("무궁화 꽃이 피었습니다", "김진명");
        books[2] = new Book("흐르는 강물처럼", "파울로코엘료");
        books[3] = new Book("리딩으로 리드하라", "이지성");
        books[4] = new Book("사피엔스", "유발하라리");
        lastIndexNumber = 5;    // 샘플 데이터가 5개 이므로 인덱스 관리 번호로 사용

        boolean flag = true;

        final String SAVE = "1";
        final String UPDATE = "2";
        final String SEARCH_ALL = "3";
        final String SEARCH_BY_TITLE = "4";
        final String DELETE_ALL = "5";
        final String DELETE = "6";
        final String END = "0";

        // 2단계 실행의 흐름 만들어 보기
        while (flag) {
            System.out.println("===== 메뉴 선택 =====");
            System.out.println("1.저장 2.수정 3.전체 조회 4.선택 조회 5.전체 삭제 6. 선택 삭제 0.종료");
            String selectedNumber = sc.nextLine();

            if (selectedNumber.equals(SAVE)) {
                save(sc, books);
            } else if (selectedNumber.equals(UPDATE)) {
                System.out.println(">> 수정하기 호출 됨 <<");
                update(sc, books);
            } else if (selectedNumber.equals(SEARCH_ALL)) {
                readAll(books);
                System.out.println();
            } else if (selectedNumber.equals(SEARCH_BY_TITLE)) {
                searchByTitle(sc, books);
            } else if (selectedNumber.equals(DELETE_ALL)) {
                deleteAll(books);
            } else if (selectedNumber.equals(DELETE)) {
                searchDelete(sc, books);
            } else if (selectedNumber.equals(END)) {
                System.out.println(">> 프로그램 종료 <<");
                flag = false;

            } else {
                System.out.println(">>> 잘못된 선택입니다 <<<");
            }
        }
    } // end of main


}
