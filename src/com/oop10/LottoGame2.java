package com.oop10;

public class LottoGame2 {
    public static void main(String[] args) {
//        int game;
//        for (int i = 1; i <= 6; i++) {
//            game = LottoNumberMaker.makeNumber();
//            System.out.printf(game + " ");
//        }

        int a = LottoNumberMaker.makeNumber();

        int b = LottoNumberMaker.makeNumber();
        while (b == a) {    // 조건식이 참이면 중괄호를 실행해서 false가 될때까지 동작
            b = LottoNumberMaker.makeNumber();
        }

        int c = LottoNumberMaker.makeNumber();
        while (c == a || c == b) {
            c = LottoNumberMaker.makeNumber();
        }

        int d = LottoNumberMaker.makeNumber();
        while (d == a || d == b || d == c) {
            d = LottoNumberMaker.makeNumber();
        }

        int e = LottoNumberMaker.makeNumber();
        while (e == a || e == b || e == c || e == d) {
            e = LottoNumberMaker.makeNumber();
        }

        int f = LottoNumberMaker.makeNumber();
        while (f == a || f == b || f == c || f == d || f == e) {
            f = LottoNumberMaker.makeNumber();
        }

        System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + f + " ");
    }
}
