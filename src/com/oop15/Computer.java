package com.oop15;

public class Computer {

    private String name;
    private Cpu intell;
    private Cpu AMD;

    public Computer(String name){
        this.name = name;
        this.intell = new Cpu("인텔");
        this.AMD = new Cpu("AMD");
    }

    public void showInfo(){
        System.out.println(name + "은(는) ");
        intell.use();
        AMD.use();
    }
}
