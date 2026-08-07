package swing.ch03;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JFrame {

    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;

    // 패널 - 컴포넌트를 그룹화 시킬 수 있다.(패널마다 다른 배치관리자를 설정할 수 있다.)
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;

    public MyPanel(){
        setTitle("패널 연습");
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        initData();
        setInitLayout();
        setVisible(true);
    }

    private void initData(){
        button1 = new JButton("버튼1");
        button2 = new JButton("버튼2");
        button3 = new JButton("버튼3");
        button4 = new JButton("버튼4");

        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();

    }
    private void setInitLayout(){

        // 루트 패널에 배치 관리자 --> 격자 무늬 : GridLayout()
        setLayout(new GridLayout(2,2));

        // 패널에 배치 관리자 설정 --> 수직 수평 : FlowLayout()
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        panel4.setLayout(new FlowLayout(FlowLayout.RIGHT,20,50));

        panel1.setBackground(Color.YELLOW);
        panel2.setBackground(Color.BLUE);
        panel3.setBackground(Color.GREEN);
        panel4.setBackground(Color.MAGENTA);

        panel1.add(button1);
        panel1.add(button2);
        panel4.add(button3);
        panel4.add(button4);

        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);
    }

    public static void main(String[] args) {
        new MyPanel();
    }

}
