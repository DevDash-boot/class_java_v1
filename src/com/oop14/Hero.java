package com.oop14;

public class Hero {
    String name;
    int hp;

    public Hero(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    void attack() {
        System.out.println(name + "이 공격합니다.");
    }

    public static void main(String[] args) {
        Warrior warrior = new Warrior("전사", 100);
        Archer archer = new Archer("궁수", 80);
        Wizard wizard = new Wizard("마법사", 60);

        warrior.attack();
        warrior.comboAttack();
        archer.fireArrow();
        wizard.freezing();


    }
}
