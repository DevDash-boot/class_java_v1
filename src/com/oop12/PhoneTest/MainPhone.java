package com.oop12.PhoneTest;

import java.util.Scanner;

public class MainPhone {
    static int lastIndex = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // 입력 스캐너
        Phone[] phones = new Phone[100]; // 100개의 전화번호 저장

        // 샘플
        phones[0] = new Phone("짱구", "010-1111-1111");
        phones[1] = new Phone("해리포터", "010-2222-2222");
        phones[2] = new Phone("도라에몽", "010-3333-3333");
        phones[3] = new Phone("둘리", "010-4444-4444");

        lastIndex = 4;  // 마지막 인덱스

        final String SAVE = "1";            // 저장
        final String UPDATE = "2";          // 수정
        final String SEARCH_ALL = "3";      // 전체 조회
        final String CHOICE_SEARCH = "4";   // 선택 조회
        final String DELETE_ALL = "5";      // 전체 삭제
        final String CHOICE_DELETE = "6";   // 선택 삭제
        final String END = "0";             // 종료

        boolean flag = true; // 상태 변경 true -> 실행, false -> 멈춤

        while (flag) {
            System.out.println("===== 전화번호부 관리 =====");
            System.out.println("1.저장 2.수정 3.전체 조회 4.선택 조회 5.전체 삭제 6. 선택 삭제 0.종료");

            String selNum = sc.nextLine();

            if (selNum.equals(SAVE)) {     // 저장
                PhoneManager.save(sc, phones);
            } else if (selNum.equals(UPDATE)) {     // 수정
                PhoneManager.update(sc, phones);
            } else if (selNum.equals(SEARCH_ALL)) {   // 전체 조회
                PhoneManager.searchAll(phones);
            } else if (selNum.equals(CHOICE_SEARCH)) {    // 선택 조회
                PhoneManager.choiceSearch(sc, phones);
            } else if (selNum.equals(DELETE_ALL)) {       // 전체 삭제
                PhoneManager.deleteAll(phones);
            } else if (selNum.equals(CHOICE_DELETE)) {    // 선택 삭제
                PhoneManager.choiceDelete(sc, phones);
            } else if (selNum.equals(END)) {      // 종료
                System.out.println("프로그램을 종료합니다.");
                flag = false;
            } else {  // 정해진 번호 외 입력시
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    } // end of main
}
