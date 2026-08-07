package useful.ch09;

/*
 * 내부 클래스란?
 * 한 클래스 내부에 선언된 클래스를 말한다.
 * 내부 클래스를 선언하면 보통 외부 클래스와 연관이 있는 경우에 클래스가 많고
 * 다른 곳에서 거의 사용할 일이 없을 경우 내부에 클래스를 선언하기도 한다.
 *
 * 내부 클래스 종류 4가지
 * 1. 멤버 내부 클래스
 * 외부 클래스와 강하게 연결된 상태
 * 외부 클래스가 생성되어야 내부 클래스를 호출할 수 있다.
 */

public class OuterClass1 {
    private int num = 10;

    // 1. 멤버 내부 클래스
    class InnerClass{
        public void display(){
            System.out.println("num : " + num);
        }
    }   // end of Inner class

    public static void main(String[] args) {
        // 내부 클래스가 일반 멤버 클래스로 설계된 경우
        // 외부 클래스가 먼저 객체로 생성되고 내부 클래스를 생성할 수 있다.
        OuterClass1 outerClass1 = new OuterClass1();
        OuterClass1.InnerClass innerClass = outerClass1.new InnerClass();
        innerClass.display();
    }

}   // end of Outer class
