package com.oop12.PhoneTest;

import java.util.Scanner;

// 저장, 수정, 전체 조회, 선택 조회, 전체 삭제, 선택 삭제
public class PhoneManager {

    // 저장
    public static void save(Scanner sc, Phone[] phones) {
        System.out.println("*** 저장 ***");

        // 전화번호부 100개가 가득 찬 경우
        if (MainPhone.lastIndex >= phones.length) {
            System.out.println("전화번호부가 가득 찼습니다.\n");
            return;
        }

        // 새로 저장할 이름과 전화번호 입력
        System.out.print("저장할 이름: ");
        String name = sc.nextLine();
        System.out.print("저장할 전화번호: ");
        String phoneNumber = sc.nextLine();

        // 이름과 전화번호가 동시에 중복되는 경우 중복되는 연락처가 있다고 출력
        for (int i = 0; i < phones.length; i++) {
            if (phones[i] != null && phones[i].getName().equals(name) && phones[i].getPhoneNumber().equals(phoneNumber)) {
                System.out.println("입력하신 정보와 중복되는 연락처가 있습니다.\n");
                return;
            }
        }

        // 새로운 이름 덮어쓰기
        Phone phone = new Phone(name, phoneNumber);
        phones[MainPhone.lastIndex] = phone;
        System.out.println("이름: " + name + "과 전화번호: " + phoneNumber + "이 저장되었습니다.\n");
        MainPhone.lastIndex++;
    }

    // 수정
    public static void update(Scanner sc, Phone[] phones) {

        boolean flag1 = false;
        if (flag1 == false) {
            System.out.println("저장된 이름과 전화번호가 없습니다.\n");
        }

        System.out.println("*** 수정 ***");
        System.out.print("수정할 이름을 입력해주세요:");
        String searchName = sc.nextLine().trim();

        for (int i = 0; i < phones.length; i++) {
            if (phones[i] != null && phones[i].getName().equals(searchName)) {
                System.out.print("새로 저장할 이름: ");
                String newName = sc.nextLine();
                phones[i].setName(newName);

                System.out.print("새로 저장할 전화번호: ");
                String newNumber = sc.nextLine();
                phones[i].setPhoneNumber(newNumber);

                System.out.println("수정되었습니다.\n");
                flag1 = true;
                break;
            }
        }
        // 저장된 이름과 전화번호가 없는 경우

    }

    // 전체 조회
    public static void searchAll(Phone[] phones) {
        System.out.println("*** 전체 조회 ***");

        // 전화 번호부가 비어있는 경우
        if (MainPhone.lastIndex == 0) {
            System.out.println("저장된 전화번호가 없습니다.\n");
            return;
        }
        for (int i = 0; i < phones.length; i++) {
            if (phones[i] != null) {
                System.out.println("이름: " + phones[i].getName() + ", 전화번호: " + phones[i].getPhoneNumber());
            }
        }
        // 저장된 연락처 개수와 여분의 공간 출력
        System.out.println("\n총 " + MainPhone.lastIndex + "개의 연락처가 있습니다.");
        System.out.println((phones.length - MainPhone.lastIndex) + "개의 연락처를 저장할 수 있습니다.\n");
    }

    // 선택 조회
    public static void choiceSearch(Scanner sc, Phone[] phones) {
        System.out.println("*** 선택 조회 ***");
        System.out.print("조회할 이름: ");
        String name = sc.nextLine().trim();

        boolean flag1 = false;  // 이름과 전화번호가 있는 지 없는 지 true = 있음, false = 없음

        for (int i = 0; i < phones.length; i++) {
            if (phones[i] != null && phones[i].getName().equals(name)) {
                System.out.println(name + "이 조회되었습니다.\n");
                phones[i].showInfo();
                System.out.println();   // 한 칸 띄우기
                flag1 = true;
                break;
            }
        }
        if (flag1 == false) { // 조회가 없어 조회를 할 수 없는 경우
            System.out.println("조회된 이름이 없습니다.\n");
        }
    }

    // 전체 삭제
    public static void deleteAll(Phone[] phones) {
        System.out.println("*** 전체 삭제 ***");
        for (int i = 0; i < phones.length; i++) {
            phones[i] = null;
        }
        System.out.println("전화번호가 전부 삭제 되었습니다.\n");
        MainPhone.lastIndex = 0;  // 전체 삭제 후 초기화
    }

    // 선택 삭제
    public static void choiceDelete(Scanner sc, Phone[] phones) {
        System.out.println("*** 선택 삭제 ***");

        // 현재 저장된 전화번호가 없는 경우
        if (MainPhone.lastIndex == 0) {
            System.out.println("저장된 전화번호가 없습니다.");
        }

        int selectName = -1;    // -1은 조회할 이름이 없는 경우를 나타내는 것

        System.out.print("삭제할 이름: ");
        String name = sc.nextLine().trim();
        for (int i = 0; i < phones.length; i++) {
            if (phones[i] != null && phones[i].getName().equals(name)) {
                selectName = i; // i값이 0부터 1씩 증가하면서 삭제할 이름의 i값에 도달한경우
                System.out.println(name + "이(가) 선택되었습니다.\n");
                break;
            }
        }
        if (selectName == -1) { // 삭제할 이름이 없는 경우
            System.out.println("삭제할 이름이 조회되지 않았습니다.");
            return;
        }
        System.out.println("[삭제]");
        phones[selectName].showInfo();
        System.out.println(name + "이(가) 삭제되었습니다.");

        // 삭제한 자리 뒤의 요소를 한 칸씩 자리를 스위치해서 앞으로 땡긴다.
        for (int i = selectName; i < MainPhone.lastIndex; i++) {
            phones[i] = phones[i + 1];
        }
        // 인덱스의 빈칸이 있다면 lastIndex값을 빼서 빈 공간을 만들어준다.
        phones[MainPhone.lastIndex - 1] = null;
        MainPhone.lastIndex--;
    }
}


