package swing.ch01;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.FlatteningPathIterator;

public class MyFrame extends JFrame {

    // 배열 활용
    private JButton[] buttons = new JButton[4];

    // 프레임
    public MyFrame() {
        super.setTitle("배치 관리자 연습");       // 프레임 제목 설정
        super.setSize(500, 500);    // 가로, 세로 크기 설정
        super.setVisible(true); // 화면에 보이게 한다.
        setDefaultCloseOperation(EXIT_ON_CLOSE); // 좌측 상단 닫기 버튼 클릭 시 종료되게 한다.

        initData();
        setInitLayout();
        setLocationRelativeTo(null);
    }

    // 버튼 생성
    public void initData() {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton("button" + (i + 1));
        }
    }

    public void setInitLayout() {
        // 배치 관리자 선언
        FlowLayout flowLayout = new FlowLayout();
        // 컴포넌트들을 수평, 수직으로 프레임에 배치해주는 역할
        super.setLayout(flowLayout);

        for (int i = 0; i < buttons.length; i++) {
            if (buttons[i] != null) {
                add(buttons[i]);
            }
        }
    }


    @Override
    public void setLocationRelativeTo(Component c) {
        super.setLocationRelativeTo(c);
    }

    // 프레임
    public static void main(String[] args) {
        new MyFrame();
    }

}
