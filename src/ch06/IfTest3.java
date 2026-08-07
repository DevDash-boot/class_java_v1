package ch06;

public class IfTest3 {
    public static void main(String[] args) {
        // if(조건식){...} else if {...} else{...}

        int age = 27;

        if (age <= 7) {
            System.out.println("아직 학교에 다니지 않았습니다.");
        } else if (age <= 11) {
            System.out.println("초등학생");
        } else if (age <= 15) {
            System.out.println("중학생");
        } else if (age <= 18) {
            System.out.println("고등학생");
        } else {
            System.out.println("성인");
        }
        System.out.println("프로그램을 종료합니다.");

    } // end of main
} // end of class
