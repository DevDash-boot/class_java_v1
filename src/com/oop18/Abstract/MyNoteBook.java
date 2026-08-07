package com.oop18.Abstract;

public class MyNoteBook extends NoteBook{

    @Override
    public void display() {
        System.out.println("노트북에 화면을 출력합니다.");
    }

    public static void main(String[] args) {
        Computer computer = new MyNoteBook();
        computer.display();
        computer.typing();
        computer.trunOn();
        computer.trunOff();
    }
}
