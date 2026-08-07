package com.oop15;

public class Cpu {

    private String type;

    public Cpu(String type) {
        this.type = type;
    }

    public void use(){
        System.out.println(type + "을 사용 중입니다.");
    }

}
