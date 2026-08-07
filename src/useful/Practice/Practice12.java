package useful.Practice;

import java.util.ArrayList;
import java.util.Scanner;

public class Practice12 {

    public static void main(String[] args) {

        ArrayList<User> list = new ArrayList<>();

        list.add(new User("kim123", "1234", 20));
        list.add(new User("kim", "5678", 25));

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("아이디 입력: ");
            String id = sc.nextLine();
            System.out.print("비밀번호 입력: ");
            String password = sc.nextLine();

            boolean login = false;

            for(int i = 0; i < list.size(); i++) {
                User u = list.get(i);
                if(u.id.equals(id) && u.password.equals(password)) {
                    login = true;
                    break;
                }
            }

            if (login) {
                System.out.println("로그인 성공");
            } else {
                System.out.println("아이디 또는 비밀번호가 틀렸습니다.");
            }

        } catch (Exception e) {
            System.out.println("잘못된 입력입니다.");
        }

        System.out.println(
                list.get(0).equals(list.get(1))
        );
        sc.close();
    }

    static class User {
        String id;
        String password;
        int age;

        public User(String id, String password, int age) {
            this.id = id;
            this.password = password;
            this.age = age;
        }
        @Override
        public boolean equals(Object obj) {

            User u = (User) obj;

            return id.equals(u.id) && password.equals(u.password);
        }
    }
}