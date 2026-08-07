package useful.Practice;

import java.util.ArrayList;

public class Practice11 {

    public static void main(String[] args) {

        ArrayList<Student> list = new ArrayList<>();

        list.add(new Student("2025001", "홍길동", 90));
        list.add(new Student("2025002", "김철수", 80));
        list.add(new Student("2025003", "고길동", 100));


        System.out.println("===== 학생 목록 =====\n");

        int sum = 0;
        int max = list.get(0).score;
        int min = list.get(0).score;


        for (Student s : list) {

            System.out.println(s);

            sum += s.score;

            if (s.score > max) {
                max = s.score;
            }

            if (s.score < min) {
                min = s.score;
            }
        }


        double avg = (double) sum / list.size();


        System.out.println("===== 결과 =====");
        System.out.println("총점 : " + sum);
        System.out.println("평균 : " + avg);
        System.out.println("최고점 : " + max);
        System.out.println("최저점 : " + min);

    }


    static class Student {

        String id;
        String name;
        int score;


        public Student(String id, String name, int score) {
            this.id = id;
            this.name = name;
            this.score = score;
        }


        @Override
        public String toString() {
            return "학번 : " + id +
                    "\n이름 : " + name +
                    "\n점수 : " + score + "\n";
        }
    }
}