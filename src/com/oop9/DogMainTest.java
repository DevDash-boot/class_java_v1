package com.oop9;

public class DogMainTest {
    public static void main(String[] args) {
        Dog d1 = new Dog("포메라니안");
        d1.setName("진돗개");
        d1.setAge(4);
        d1.setWeight(14);
        System.out.println(d1.getName());
        System.out.println(d1.getAge());
        System.out.println(d1.getWeight());
    }

}
