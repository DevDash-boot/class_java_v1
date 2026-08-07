package com.oop5;

public class Rice {
    String menu;    // 메뉴
    int amount;     // 남은 양

    public Rice(String m, int a) {
        menu = m;
        amount = a;
    }

    // 먹은만큼 줄어든다. 다먹으면 false, 다 못먹으면 true 반환 리턴값 설계
    boolean reduce(int eatAmount){
       if(amount >= eatAmount){
           amount -= eatAmount;
           return true;
       }else{
           return false;
       }
    }

    // Info()
    void riceInfo(){
        System.out.println("메뉴: " + menu);
        System.out.println("남은 양: " + amount);
    }

}
