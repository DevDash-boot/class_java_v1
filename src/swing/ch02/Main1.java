package swing.ch02;

import javax.swing.*;

public class Main1 {
    public static void main(String[] args) {
        MyComponent myComponent = new MyComponent();
        myComponent.run();

        // 문제 1. 메인 함수에서 텍스트 필드에 접근해서 객체 안에 문자열 값을 코드로 주입
        JTextField field1 = myComponent.getTextField();
        field1.setText("홍길동");


    }
}
