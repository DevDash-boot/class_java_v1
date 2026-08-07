package com.oop4;

public class CoffeeMachineTest {

    public static void main(String[] args) {
        CoffeeMachine machine1 = new CoffeeMachine(500, 80);
        String result1 = machine1.makeCoffee();
        System.out.printf(result1);
        machine1.makeCoffee();
        machine1.showInfo();
        machine1.refillWater(234);
        machine1.refillCoffee(45);
        machine1.countCoffee();
    }

}
