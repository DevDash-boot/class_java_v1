package swing.ch06;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// 테두리 벽 도달시 움직이지 못하게 + 적이동
public class MyFrame3 extends JFrame {

    private JLabel backgroundMap;
    private JLabel player;
    private JLabel enemy, enemy2, enemy4;
    private final int STEP = 20;  // 좌우 이동

    // player 아이콘
    ImageIcon playerIconL = new ImageIcon("images/playerL.png");
    ImageIcon playerIconR = new ImageIcon("images/playerR.png");

    // enemy 아이콘
    ImageIcon enemyIconL = new ImageIcon("images/enemyL.png");
    ImageIcon enemyIconR = new ImageIcon("images/enemyR.png");

    public MyFrame3() {
        initData();
        setInitLayout();
        addEventListener();
        stool();

        startEnemy1();
        startEnemy2();
        setVisible(true);
    }

    private void startEnemy1() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int ex = enemy.getX();
                int ey = enemy.getY();
                int direction = 10;

                while (true) {
                    ex += direction;
                    if (ex >= 880) {
                        direction = -10;
                        enemy.setIcon(enemyIconL);
                    } else if (ex <= 80) {
                        direction = 10;
                        enemy.setIcon(enemyIconR);
                    }
                    enemy.setLocation(ex, ey);
                    try {
                        // 속도
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }   // end of try-catch
                }   // end of while
            }   // end of run
        }).start();
    }
    private void startEnemy2() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int ex = enemy2.getX();
                int ey = enemy2.getY();
                int direction = 10;

                while (true) {
                    ex += direction;
                    if (ex >= 720) {
                        direction = -10;
                        enemy2.setIcon(enemyIconL);
                    } else if (ex <= 220) {
                        direction = 10;
                        enemy2.setIcon(enemyIconR);
                    }
                    enemy2.setLocation(ex, ey);
                    try {
                        // 속도
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }   // end of try-catch
                }   // end of while
            }   // end of run
        }).start();
    }

    private void stool() {
        Rectangle[] stools = {new Rectangle(50, 250, 50, 30),
                new Rectangle(50, 340, 50, 30),
                new Rectangle(50, 430, 50, 30),
                new Rectangle(180, 250, 450, 30),
                new Rectangle(180, 340, 450, 30),
                new Rectangle(180, 430, 450, 30),
                new Rectangle(750, 250, 50, 30),
                new Rectangle(750, 340, 50, 30),
                new Rectangle(750, 430, 50, 30)};
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
        player.setSize(50, 50);
        player.setLocation(200, 535);

        // 적 이미지 설정
        enemyIconL = new ImageIcon("images/enemyL.png");
        enemy = new JLabel(enemyIconR);
        enemy.setSize(50, 50);
        enemy.setLocation(500, 535);

        enemy2 = new JLabel(enemyIconR);
        enemy2.setSize(50, 50);
        enemy2.setLocation(500, 415);
    }

    private void setInitLayout() {
        // 루트 패널에 설정
        setLayout(null);
        add(backgroundMap);
        backgroundMap.add(player);  // 배경 이미지 위에 player 붙이기
        backgroundMap.add(enemy);  // 배경 이미지 위에 enemy 붙이기
        backgroundMap.add(enemy2);  // 배경 이미지 위에 enemy 붙이기
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
                switch (keyCode) {
                    case KeyEvent.VK_UP:
                        if (y - STEP >= 10) {
                            y -= STEP;
                        }
                        break;
                    case KeyEvent.VK_LEFT:
                        if (x - STEP >= 45) {
                            player.setIcon(playerIconL);
                            x -= STEP;
                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (x + STEP <= 860) {
                            player.setIcon(playerIconR);
                            x += STEP;
                        }
                        break;
                    case KeyEvent.VK_DOWN:
                        if (y + STEP <= 520) {
                            y += STEP;
                        }
                        break;
                    case KeyEvent.VK_ESCAPE:
                        player.setLocation(200, 511);
                        break;
                    default:
                        return;
                } // end of switch
                player.setLocation(x, y);    // 방향키 이벤트를 받아서 다시 플레이어의 좌표값 지정
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }

    public static void main(String[] args) {
        new MyFrame3();
    }
}
