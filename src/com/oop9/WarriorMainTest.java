package com.oop9;

public class WarriorMainTest {
    public static void main(String[] args) {
        Warrior w1 = new Warrior("광전사");
        Warrior w2 = new Warrior("일반전사");

        // Warrior의 멤버 변수의 접근 제어 지시자는 private이라 여기에서 접근 불가능
        // 외부에서 필요하다면 값을 확인할 수 있는 방법?(특히, 값만)
        // getter, setter 메서드를 사용해서 설계해볼 수 있다.(외부 사용자가 활용해서 쓸 수 있도록)

        // get, set 메서드 확인
        // 필요에 의해서 멤버 변수 상태값을 변경해보자. 객체의 상태 변경은 행위(메서드)를 통해서 변경해야 한다.
        w1.setHp(180);
        w1.setLevel(0);
        w1.setName("광전사 2성");
        System.out.println("이름: " + w1.getName() + " 레벨: " + w1.getLevel() + " 체력: " + w1.getHp());

    }
}
