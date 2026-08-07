package swing.ch03;

import javax.swing.*;
import java.awt.*;

public class MyImageFrame extends JFrame {

    // JPanel jPanel; 대신에 사용 가능하다.
    // JPanel을 상속한 클래스라 기능을 다 물려 받았다.
    MyImagePannel myImagePannel;

    public MyImageFrame(){
        setTitle("중첩 클래스 활용");
        setSize(600,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        myImagePannel = new MyImagePannel();
        add(myImagePannel);

        setVisible(true);
    }

    // 2. 정적 내부 클래스 선언
    static class MyImagePannel extends JPanel {

        private Image image1;

        public MyImagePannel(){
            // 이미지 읽어오기
            image1 = new ImageIcon("image1.png").getImage();
        }

        // 의존 관계
        // Grapthics : 그림을 그릴 수 있다.
        @Override
        public void paint(Graphics g) {
            super.paint(g);

            // 문자
            g.drawString("이미지 게임", 200,200);

            // 선 긋기 (x1, y1)에서  (x2, y2)로 선
            g.drawLine(100, 100, 300, 100);

            // 이미지 그리기(넣을 이미지, x축 위치, y축 위치, 가로 크기, 세로 크기)
            g.drawImage(image1, 300,300,200,200,null);

        }
    }   // end of Inner Class

    // 테스트 코드 작성
    public static void main(String[] args) {
        new MyImageFrame();
    }   // end of main


}   // end of Outer Class
