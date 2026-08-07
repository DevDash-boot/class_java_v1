package swing.ch02;

import javax.swing.*;
import java.awt.*;

public class NoLayout1 extends JFrame {

    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JPanel panel;
    private JTextField textField;

    public NoLayout1() {
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initData();
        setInitLayout();
        setVisible(true);   // 버그 때문에 마지막에 호출하는게 좋다.

    }

    private void initData() {
        button1 = new JButton("버튼1");
        button2 = new JButton("버튼2");
        button3 = new JButton("버튼3");

        panel = new JPanel();
        textField = new JTextField("안녕하세요", 10);

    }

    private void setInitLayout() {
        // setLayout()에 null 값을 주면 좌표 기반으로 배치할 수 있다.
        setLayout(null);

        // 주의점 : 좌표 기반 배치 관리자를 사용하면 반드시 컴포넌트의 크기를 지정해야하고, x축, y축을 지정해야 한다.

        button1.setSize(100, 100); // 버튼 크기 설정
        button2.setSize(75,75);
        button3.setSize(125,125);

        button1.setLocation(200,200);       // 버튼 위치 설정 x축, y축
        button2.setLocation(30,30);
        button3.setLocation(400,400);
        Font font = new Font("궁서체", Font.ITALIC, 15);   // 폰트
        button3.setFont(font);

        add(button1);   // 프레임에 추가
        add(button2);
        add(button3);

        panel.setSize(300,100);
        panel.setLocation(320, 100);
        panel.setBackground(Color.YELLOW);   // 배경색
        panel.setLayout(null);  // 패널 안 좌표 기반 배치

        textField.setSize(150,50);
        textField.setLocation(25, 25);
        panel.add(textField);       // 패널에 텍스트 필드 추가
        add(panel);

    }

    public static void main(String[] args) {
        new NoLayout1();
    }

}
