package oop_test.ch04;

public class Main {
    public static void main(String[] args) {
        MemberService memberService = new MemberService();
        memberService.registerMember("user01", "홍길동");
        memberService.registerMember("user02", "고길동");

        // 전체 회원 목록 확인
        memberService.printAllMembers();
    }
}
