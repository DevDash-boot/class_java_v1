package com.oop1.ClassRoom;

public class BookMainTest1 {

    public static void main(String[] args) {

        // new 키워드를 3번 사용했기 때문에 Heap 메모리 영역에 객체가 3개 생성되었다.
        // 메모리에 올라가면(인스턴스화) 객체라고 부를 수 있다.
        Book b1 = new Book();
        Book b2 = new Book();
        Book b3 = new Book();

        System.out.println("book1: " + b1);
        System.out.println("book2: " + b2);
        System.out.println("book3: " + b3);

    } // end of main
} // end of class
