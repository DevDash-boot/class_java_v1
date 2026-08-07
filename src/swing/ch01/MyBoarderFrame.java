package swing.ch01;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MyBoarderFrame extends JFrame {

    // 1. 배열로 변경
    JButton[] buttons = new JButton[5];
    JPanel[] jPanels = new JPanel[5];

    Random random = new Random();

    String[] directions = {
            BorderLayout.NORTH,
            BorderLayout.SOUTH,
            BorderLayout.EAST,
            BorderLayout.WEST,
            BorderLayout.CENTER
    };

    public MyBoarderFrame() {

        setTitle("boarderLayout 연습");
        setSize(600, 500);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        initData();
        setInitLayout();

        setVisible(true);
    }

    public void initData() {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton("button " + (i + 1));
            jPanels[i] = new JPanel();
        }
    }

    public void setInitLayout() {
        setLayout(new BorderLayout());

        for (int i = 0; i < buttons.length; i++) {
            if (buttons[i] != null) {
                // 랜덤 rgb 값
                int[] rgb1 = new int[3];
                int[] rgb2 = new int[3];
                for (int j=0; j<3 ; j++){
                    rgb1[j] = random.nextInt(256);
                    rgb2[j] = random.nextInt(256);
                }
                // 배경색
                jPanels[i].setBackground(new Color(rgb1[0],rgb1[1],rgb1[2]));
                buttons[i].setBackground(new Color(rgb2[0],rgb2[1],rgb2[2]));
                // 버튼 글자 색
                buttons[i].setForeground(Color.WHITE);
                // 패널에 버튼 생성
                jPanels[i].add(buttons[i]);
                // 패널 위치 지정
                add(jPanels[i], directions[i]);
            }
        }
    }

    public static void main(String[] args) {
        new MyBoarderFrame();
    }
}
