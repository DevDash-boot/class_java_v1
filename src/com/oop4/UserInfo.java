package com.oop4;

public class UserInfo {

    String userId;
    String userPw;
    String userName;
    String userAddress;
    String phoneNumber;

    // 객체가 생성될 때 가장 먼저 실행되는 부분은 생성자이다.
    // this.userId = userId;가 아닐경우 userId = userId는 자기자신을 userId에 넣는 것이다.
    public UserInfo(String id) {
        userId = id;
    }

    public UserInfo(String id, String pw) {
        userId = id;
        userPw = pw;
    }

    public UserInfo(String id, String pw, String n) {
        userId = id;
        userPw = pw;
        userName = n;
    }

    public UserInfo(String id, String pw, String n, String a) {
        userId = id;
        userPw = pw;
        userName = n;
        userAddress = a;
    }

    public UserInfo(String id, String pw, String n, String a, String pn) {
        userId = id;
        userPw = pw;
        userName = n;
        userAddress = a;
        phoneNumber = pn;
    }

}
