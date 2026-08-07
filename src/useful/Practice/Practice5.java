package useful.Practice;

public class Practice5 {
    public static void main(String[] args) {
        Student s1 = new Student("2025001","홍길동");
        Student s2 = new Student("2025001","홍길동");

        System.out.println(s1.equals(s2));
    }


    static class Student{
        String id;
        String name;

        public Student(String id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            Student s = (Student) obj;
            return id.equals(s.id) && name.equals(s.name);
        }
    }

}
