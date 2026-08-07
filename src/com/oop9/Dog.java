package com.oop9;

public class Dog {

    private String name;
    private int age;
    private int weight;

    public Dog(String name) {
        this.name = name;
        age = 5;
        weight = 20;
    }

    // 1. get 메서드를 만들어 주세요
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    // 2. set 메서드를 만들어 주세요
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0) {
            System.out.println("나이는 -(음수)가 될 수 없습니다.");
            return;
        }
        this.age = age;
    }

    public void setWeight(int weight) {
        if(weight < 0){
            System.out.println("몸무게는 -(음수)가 될 수 없습니다.");
            return;
        }
        this.weight = weight;
    }


}
