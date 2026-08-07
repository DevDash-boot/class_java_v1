package com.oop12;

public class Book {

    private String title;
    private String author;
    private int totalPage;

    // 이 생성자는 외부에서 호출 불가 - private
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public Book(String title, String author, int totalPage) {
        this(title, author);
        this.totalPage = totalPage;
    }

    // getter - 읽기만 가능
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void showInfo() {
        System.out.println("===== 책 정보 =====");
        System.out.println("제목: " + title);
        System.out.println("저자: " + author);
        if (totalPage != 0) {
            System.out.println("총 페이지 수: " + totalPage);
        }
    }
}
