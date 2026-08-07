package useful.Practice;

public class Practice4 {
    public static void main(String[] args) {
        Person p = new Person("홍길동", 20);
        System.out.println(p);

    }

    static class Person {
        String s;
        int i;

        public Person(String s, int i) {
            this.s = s;
            this.i = i;
        }

        @Override
        public String toString() {
            return "이름 : " + s + "\n나이 : " + i;
        }
    }
}

