package swing.ch03;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;

public class MyImageFrame2 extends JFrame {
    MyImagePannel myImagePannel;

    public MyImageFrame2(){
        setTitle("중첩 클래스 활용");
        setSize(1000,1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        myImagePannel = new MyImagePannel();
        add(myImagePannel);

        setVisible(true);
    }

    // 2. 정적 내부 클래스 선언
    static class MyImagePannel extends JPanel {

        private Image image1;
        private Image image2;
        private Image image3;
        private Image image4;
        private Image image5;

        public MyImagePannel(){
            // 이미지 읽어오기
            image1 = new ImageIcon("land.jpg").getImage();
            image2 = new ImageIcon("tree.png").getImage();
            image3 = new ImageIcon("tree.png").getImage();
            image4 = new ImageIcon("tree.png").getImage();
            image5 = new ImageIcon("tree.png").getImage();
        }

        // 의존 관계
        // Grapthics : 그림을 그릴 수 있다.
        @Override
        public void paint(Graphics g) {
            super.paint(g);

            // 이미지
            //g.drawImage(image1, 0,0,1000,1000,null);
            g.drawImage(image2, 200,500,200,250,null);
            g.drawImage(image3, 100,500,200,250,null);
            g.drawImage(image4, 700,500,200,250,null);
            g.drawImage(image5, 800,500,200,250,null);

            // 몸체
            g.setColor(Color.white);
            g.fillRect(400,400,300,300);
            g.setColor(Color.BLACK);
            g.drawRect(400,400,300,300);

            // 지붕
            int[] x = {400,550,700};
            int[] y = {400,270,400};

            g.setColor(new Color(255,255,224,255));
            g.fillPolygon(x,y,3);
            g.setColor(Color.BLACK);
            g.drawPolygon(x,y, 3);

            // 문
            g.setColor(Color.BLACK);
            g.drawRect(450,550,100,150);
            g.setColor(Color.gray);
            g.fillRect(450,550,100,150);

            // 문 손잡이
            g.setColor(Color.BLACK);
            g.fillRoundRect(520,620,20,20, 100,100);

            // 창문
            g.setColor(new Color(170,210,230));
            g.fillRoundRect(580,460,80,80,100, 100);

            g.setColor(Color.BLACK);
            g.drawRoundRect(580,460,80,80,100, 100);
            g.drawLine(620,460,620,540);
            g.drawLine(580,500,660,500);

        }
    }   // end of Inner Class

    // 테스트 코드 작성
    public static void main(String[] args) {
        new MyImageFrame2();
    }   // end of main


}   // end of Outer Class
