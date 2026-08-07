package com.oop1.Exercise1;

public class UserMainTest {
    public static void main(String[] args) {
        User u1 = new User();

        u1.name = "홍길동";
        u1.address = "부산광역시 부산진구";
        u1.phoneNumber = "010-1234-5678";

        System.out.println("이름: " + u1.name);
        System.out.println("주소: " + u1.address);
        System.out.println("번호: " + u1.phoneNumber);

    }
}
