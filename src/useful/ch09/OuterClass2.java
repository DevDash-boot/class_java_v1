package useful.ch09;

public class OuterClass2 {

    private static int num = 10;

    // 2. 정적 내부 클래스
    static class InnerClass{
        public void display(){
            System.out.println("num : " + num);
        }
    }   // end of InnerClass

    public static void main(String[] args) {
        // 외부 클래스와 이름만 묶인 상태
        // 외부 객체 생성 없이도 생성이 가능
        OuterClass2.InnerClass innerClass = new InnerClass();   // new  OuterClass2.InnerClass();가 정석
        innerClass.display();
    }   // end of main

}   // end of OuterClass
