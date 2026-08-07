package swing.ch05;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MoveLabelFrame extends JFrame {

    private JLabel label;
    private final int MOVE_STEP = 50;

    public MoveLabelFrame(){
        initData();
        setInitLayout();
        addEventListener();
        setVisible(true);
    }

    private void initData() {
        setTitle("방향키로 별 움직이기 연습");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        label = new JLabel("☆");
        label.setFont(new Font("맑은 고딕", Font.ITALIC, 30));
        // 좌표 기반 - 크기, 위치 직접 설정
        label.setSize(50,50);   // label 크기
        label.setLocation(200,200); // label 시작 위치
    }

    private void setInitLayout() {
        setLayout(null);    // 좌표 기반
        add(label);
    }

    private void addEventListener() {
        this.setFocusable(true);
        this.requestFocusInWindow();

        // this로 선언해야 된다.
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                int x = label.getX();
                int y = label.getY();
                label.setText("★");

                if (keyCode == KeyEvent.VK_UP) {
                    label.setLocation(x, y - MOVE_STEP);
                } else if(keyCode == KeyEvent.VK_LEFT) {
                    label.setLocation(x - MOVE_STEP, y);
                } else if(keyCode == KeyEvent.VK_RIGHT) {
                    label.setLocation(x + MOVE_STEP, y);
                } else if(keyCode == KeyEvent.VK_DOWN) {
                    label.setLocation(x , y + MOVE_STEP);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                label.setText("☆");
            }
        });
    }

    public static void main(String[] args) {
        new MoveLabelFrame();
    }


}
