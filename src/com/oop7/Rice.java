package com.oop7;

public class Rice {

    private int menu;    // 메뉴
    int money;      // 금액

    public Rice(int m, int p) {
        menu = m;
        money = p;
    }

    // Student.java에서 eatRice를 호출할 때 사용하는 부분
    String RiceMenu(int menu) {
        if (menu == 1) {
            money = 3500;
            return "김치볶음밥";
        } else if (menu == 2) {
            money = 3000;
            return "라면";
        } else if (menu == 3) {
            money = 2000;
            return "김밥";
        } else {
            money = 0;
            return "잘못된 번호입니다. 1, 2, 3번 중 한 개의 번호를 선택해주세요.";
        }
    }

    public void riceInfo() {
        System.out.println("===== 메뉴 조회 =====");
        System.out.println("메뉴: " + menu);
        System.out.println("가격: " + money);
    }


}
