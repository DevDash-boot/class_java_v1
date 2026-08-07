package swing.ch05;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEvenetListenerFrame extends JFrame {

    private final int FRAME_SIZE = 500;
    private JTextArea textArea; // 여러 글자를 받을 수 있다.

    public KeyEvenetListenerFrame() {
        initData();
        setInitLayout();
        addEventListener();
        setVisible(true);
    }

    private void initData() {
        setSize(FRAME_SIZE, FRAME_SIZE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setResizable(false);  // 사용자 마우스로 크기를 조정 못하게 막음. true는 조정 가능

        textArea = new JTextArea();
    }

    private void setInitLayout() {
        add(textArea);

    }

    private void addEventListener() {
        // 이벤트 리스너 등록 - 익명 내부 클래스로 구현
        textArea.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) { // 키 눌렀을때
                System.out.println("키 누름 : " + e.getKeyCode());
                // 키보드 이벤트를 받아서 위쪽 화살표면 위쪽 화살표를 textArea에 출력
                // 이전 내용이 사라지면 안된다.
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    textArea.append("️ ⬅️ 좌\n");
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    textArea.append(" ⬆️ 상\n");
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    textArea.append("️ ➡️ 우\n");
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    textArea.append("️ ⬇️ 하\n");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {   // 키 뗐을 때

            }
        });
    }

    public static void main(String[] args) {
        new KeyEvenetListenerFrame();
    }

}
