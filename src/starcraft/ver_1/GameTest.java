package starcraft.ver_1;

public class GameTest {
    public static void main(String[] args) {
        Zealot z1 = new Zealot("질럿1");
        Marine m1 = new Marine("마린1");
        Marine m2 = new Marine("마린2");
        Zergling zg1 = new Zergling("저글링1");
        Zergling zg2 = new Zergling("저글링2");

        System.out.println("질럿의 이름: " + z1.getName() + " 체력: " + z1.getHp());
        System.out.println("마린의 이름: " + m1.getName() + " 체력: " + m1.getHp());
        System.out.println("저글링의 이름: " + zg1.getName() + " 체력: " + zg1.getHp());
        System.out.println("-------------------------------");

        // 질럿 -> 저글링 공격
        for (int i = 1; i < 8; i++) {
            z1.attackZergling(zg1);
            System.out.println();
        }
        zg1.showInfZergling();

        // 저글링 -> 질럿 공격
//        for (int i = 1; i < 25; i++) {
//            zg2.attackMarine(m1);
//            System.out.println();
//        }
//
//        m1.showInfoMarine();
//
//        m2.attackZergling(zg2);
//        zg2.showInfZergling();
    }
}
