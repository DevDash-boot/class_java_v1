package swing.ch06;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// 키보드 이벤트를 이용해 player 이미지가 왼쪽 오른쪽 전환
public class MyFrame2_teacher extends JFrame {

    private JLabel backgroundMap;
    private JLabel player;
    private final int LRSTEP = 30;  // 좌우 이동
    private final int UDSTEP = 119; // 위아래 이동

    ImageIcon playerIconL = new ImageIcon("images/playerL.png");
    ImageIcon playerIconR = new ImageIcon("images/playerR.png");

    public MyFrame2_teacher() {
        initData();
        setInitLayout();
        addEventListener();

        setVisible(true);
    }

    private void initData() {
        setTitle("이미지 겹치기 연습");
        setSize(1016, 639);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 배경 이미지 설정
        // ImageIcon을 이용해 이미지 불러오기
        ImageIcon backgroundIcon = new ImageIcon("images/backgroundMap.png");
        backgroundMap = new JLabel(backgroundIcon);

        // 배치 관리자 좌표 ==> 컴포넌트 사이즈와 위치를 직접 지정
        backgroundMap.setSize(1000, 600);
        backgroundMap.setLocation(0, 0);

        // 플레이어 이미지 설정
        playerIconL = new ImageIcon("images/playerL.png");
        player = new JLabel(playerIconL);
        player.setSize(100,100);
        player.setLocation(200,511 );
    }

    private void setInitLayout() {
        // 루트 패널에 설정
        setLayout(null);
        add(backgroundMap);
        backgroundMap.add(player);  // 배경 이미지 위에 player 붙이기

    }

    private void addEventListener() {
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                int x = player.getX();
                int y = player.getY();

                // 제어문 - switch - case
                switch (keyCode){
                    case KeyEvent.VK_UP :
                        y -= UDSTEP;
                        break;
                    case KeyEvent.VK_LEFT :
                        player.setIcon(playerIconL);
                        x -= LRSTEP;
                        break;
                    case KeyEvent.VK_RIGHT :
                        player.setIcon(playerIconR);
                        x += LRSTEP;
                        break;
                    case KeyEvent.VK_DOWN :
                        y += UDSTEP;
                        break;
                    case KeyEvent.VK_ESCAPE :
                        player.setLocation(200,511);
                        break;
                    default:
                        return;
                } // end of switch
                player.setLocation(x,y);    // 방향키 이벤트를 받아서 다시 플레이어의 좌표값 지정
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }

    public static void main(String[] args) {
        new MyFrame2_teacher();
    }
}
