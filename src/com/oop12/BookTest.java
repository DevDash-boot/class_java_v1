package com.oop12;

public class BookTest {
    public static void main(String[] args) {
        Book[] books = new Book[10];

        books[0] = new Book("플러터UI실전", "김근호", 300);
        books[1] = new Book("무궁화 꽃이 피었습니다.", "김진명", 500);
        books[2] = new Book("흐르는 강물처럼", "파울로코엘료", 250);
        books[3] = new Book("리딩으로 리드하라", "이지성", 450);
        books[4] = new Book("사피엔스", "유발하라리", 850);
        books[9] = new Book("홍길동전", "허균", 350);

        // books[0] 인덱스에 있는 객체의 title 출력
        String title1 = books[0].getTitle();
        String author1 = books[0].getAuthor();
        int totalPage1 = books[0].getTotalPage();

        for (int i = 0; i < books.length; i++) {
            // null값이 있는 채로 System.out.println(books[i].getTitle()); 실행 시
            // books[]에서 null이 있어서 -> NullPointerException 에러 발생
            // 이유: 객체를 생성하지 않았거나, 가리키는 주소가 없을 때 발생

            // 방어적 코드
            if (books[i] != null) {
                System.out.println("책 제목: " + books[i].getTitle() + "\t 저자: " + books[i].getAuthor() + "\t총 페이지 수: " + books[i].getTotalPage());
            }
        }
    }
}
