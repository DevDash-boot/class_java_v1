package com.oop10;

import java.util.Random;

public class LottoNumberMaker {
    // static 변수 활용
    // 난수 생성기 - 재사용
    private static Random random = new Random();

    // static 메서드 - 1 부터 45 사이의 번호를 하나 만들어서 반환
    public static int makeNumber(){
        return random.nextInt(6)+1;
    }
}
