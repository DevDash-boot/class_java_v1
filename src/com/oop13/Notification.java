package com.oop13;

public class Notification {

    public void send(String message) {
        System.out.println("일반알림: [" + message + "]");
    }

    public void send(String message, int count) {
        System.out.println("**반복 전송**");
        for (int i = 0; i < count; i++) {
            send(message);
        }
    }

    public void send(String receiver, String message) {
        System.out.println("[" + receiver + "]" + "님에게 메시지: " + "[" + message + "]");
    }

    public static void main(String[] args) {
        Notification noti = new Notification();

        noti.send("내용");
        noti.send("내용", 3);
        noti.send("받는사람", "내용");
    }
}
