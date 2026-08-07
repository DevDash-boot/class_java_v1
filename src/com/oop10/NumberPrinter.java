package com.oop10;

public class NumberPrinter {

    int id;

    // static: 인스턴스(객체)들이 공유할 수 있는 메모리 영역
    static int waitNum;    // 대기 번호

    public NumberPrinter(int id) {
        this.id = id;
        waitNum = 1;
    }

    // 번호표 출력 기능
    public void printWaitNum() {
        System.out.println(id + " 기기의 " + "대기 순번: " + waitNum);
        waitNum++;
    }
}
