package swing.ch06;

import javax.swing.*;

// 배경 화면에 플레이어 이미지 겹치기
public class MyFrame1 extends JFrame {

    private JLabel backgroundMap;
    private JLabel player;

    public MyFrame1() {
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
        ImageIcon playerIcon1 = new ImageIcon("images/playerL.png");
        ImageIcon playerIcon2 = new ImageIcon("images/playerR.png");
        player = new JLabel(playerIcon1);

        player.setSize(100, 100);
        player.setLocation(200, 511);
    }

    private void setInitLayout() {
        // 루트 패널에 설정
        setLayout(null);
        add(backgroundMap);
        backgroundMap.add(player);  // 배경 이미지 위에 player 붙이기
    }

    private void addEventListener() {
    }

    public static void main(String[] args) {
        new MyFrame1();
    }
}
