package com.oop4;

public class CoffeeMachine {

    // 커피머신의 상태(필드) : 물의 양(ml), 원두 양(g)
    int water, coffee, count = 0;

    // 생성자1
    public CoffeeMachine(int w, int c) {
        water = w;
        coffee = c;
        System.out.println(water + "g 물과 " + coffee + "ml 원두가 있습니다.");
        System.out.println("---------------------");
    }

    // 생성자2
    public CoffeeMachine() {
    }

    // 메서드 1. 물 채우기
    // retrun 받을 필요가 없으면 void
    void refillWater(int amount) {
        // 방어적 코드: 0을 입력했을 때
        if (amount > 0) {
            water += amount;
            System.out.println(amount + "ml 물을 채웠습니다.");
        } else {
            System.out.println("0보다 많은 물을 채워주세요.");
        }
    }

    // 메서드 2. 원두 채우기
    void refillCoffee(int amount) {
        if (amount > 0) {
            coffee += amount;
            System.out.println(amount + "g 원두를 채웠습니다.");
        } else {
            System.out.println("0보다 많은 원두를 채워주세요.");
        }
    }

    // 메서드 3. 커피 만들기
    // 값을 돌려받아야 할 때 return을 사용- 여기서는 String 사용
    String makeCoffee() {
        // 커피 한 잔에 물 100ml, 원드 10g 필요
        if (water >= 100 && coffee >= 10) {
            water -= 100;
            coffee -= 10;
            count++;
            return "맛있는 커피 한 잔 완성";
        } else {
            return "재료가 부족합니다. 물이나 원두를 채워주세요.";
        }
    }

    // 메서드 4. 해당하는 객체의 현재 상태값을 보여주는 기능 추가
    // 단, 여기서 콘솔창에 출력하는 기능
    void showInfo() {
        System.out.println("\n" + "남은 물과 커피");
        System.out.println("물: " + water + ", 커피: " + coffee);
    }

    // 현재 해당하는 커피 머신이 몇 잔의 커피를 만들었는지 출력하는 기능
    void countCoffee() {
        System.out.println("지금까지 만든 커피 " + count + "잔");
    }


}
