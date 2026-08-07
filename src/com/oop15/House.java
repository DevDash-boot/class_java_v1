package com.oop15;

public class House {
     private String address;

     // 합성 관계 House는 내부적으로 Room 객체들을 소유한다.
     private Room livingRoom;
     private Room bedRoom;

    public House(String address){
        this.address = address;
        // 합성 조건 1. 내부에서 객체를 만들어야한다.
        this.livingRoom = new Room("거실");
        this.bedRoom = new Room("침실");
    }

    public void showInfo(){
        System.out.println(address + "에 위치한 집입니다.");
        livingRoom.use();
        bedRoom.use();
    }

    // 합성 조건 2. Room에 대한 getter를 만들지 않았습니다.

}
