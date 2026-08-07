package com.oop16;

public class FruitMart {

    public static void main(String[] args) {
        // 다형성 활용 - 하나의 배열에 여러 타입 담기
        Banana[] banana = new Banana[10];
        banana[0] = new Banana();
        banana[1] = new Banana();

        Peach[] peach = new Peach[3];
        peach[0] = new Peach();
        peach[1] = new Peach();
        peach[2] = new Peach();

        // 다형성이 없다면 타입별로 배열을 따로 만들어야한다.
        System.out.println("---------------");

        // 즉, 다형성을 쓰면 부모 타입 배열 하나의 자식들을 모두 담을 수 있다.
        Fruit[] fruits = new Fruit[4];
        fruits[0] = new Banana();
        fruits[1] = new Peach();
        fruits[2] = new Banana();
        fruits[3] = new Apple();

        for (int i = 0; i < fruits.length; i++) {
            fruits[i].showInfo();
            // 문제 - 타입이 바나나일 때만 할인 메서드를 호출하시오
            if(fruits[i] instanceof Banana){
                ((Banana) fruits[i]).saleBanana();
            } // 만약 사과라면 할인 금액을 호출해.
            else if (fruits[i] instanceof Apple) {
                ((Apple) fruits[i]).saleApple();
            }
            System.out.println();
        }
    }
}
