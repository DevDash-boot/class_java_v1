package swing.ch04;

import com.oop14.C;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ColorChangeFrame extends JFrame implements ActionListener {

    private JButton button1;
    private JButton button2;
    private JPanel panel1;

    public ColorChangeFrame() {

        initData();
        setInitLayout();
        addEventListener();
    }

    private void initData() {
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button1 = new JButton("버튼1");
        button2 = new JButton("버튼2");
        panel1 = new JPanel();
    }

    private void setInitLayout() {
        setLayout(new BorderLayout());
        panel1.setBackground(Color.YELLOW);
        panel1.add(button1);
        panel1.add(button2);

        add(panel1);
        setVisible(true);
    }

    private void addEventListener() {
        // button1 객체에 이벤트 리스너 등록 -> 약속 -> actionPerformed() 메서드가 콜백 됨
        button1.addActionListener(this);
        button2.addActionListener(this);
    }

    // ActionListener 의 추상 메서드를 구현 메서드로 재정의
    // 미리 약속되어 있는 메서드
    // 즉, 어떤 이벤트가 발생하면 해당 메서드가 동작되도록 설계가 되어 있다.(콜백 메서드)
    @Override
    public void actionPerformed(ActionEvent e) {
        // System.out.println("actionPerformed() 메서드 호출(콜백)");
        // System.out.println(e.getSource());
        // 버튼1을 누르면 이벤트 발생으로 버튼 문구가 바뀜 - e.getSource
        // JButton selectedButton = (JButton) e.getSource();
        // selectedButton.setText("이벤트 발생");

        Random random = new Random();
        int[] rgb = new int[3];
        for(int i=0;i<3;i++){
            rgb[i] = random.nextInt(255);
        }


        if(e.getSource() == button1){
            panel1.setBackground(new Color(rgb[0],rgb[1],rgb[2]));
        }else if (e.getSource() == button2){
            panel1.setBackground(new Color(rgb[0],rgb[1],rgb[2]));
        }

    }

    public static void main(String[] args) {
        new ColorChangeFrame();

        // 메서드를 일반적으로 호출
        // 어떤 이벤트가 발생하면 콜백 불려져서 동작함 <- 콜백 메서드
    }
}
