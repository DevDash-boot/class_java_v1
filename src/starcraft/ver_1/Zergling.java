package starcraft.ver_1;

public class Zergling {
    private String name;
    private int power;
    private int hp;

    public Zergling(String name) {
        this.name = name;
        this.power = 5;
        this.hp = 35;
    }

    // get
    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public int getHp() {
        return hp;
    }

    // set
    public void setName() {
        this.name = name;
    }

    public void setPower() {
        this.power = power;
    }

    public void setHp() {
        this.hp = hp;
    }

    // 1. 저글링이 질럿을 공격합니다.
    public void attackZealot(Zealot zealot) {
        if (zealot.getHp() <= 0) {
            System.out.println(this.name + "이 이미 사망하여 공격할 수 없습니다.");
            return;
        }
        System.out.print(this.name + "이 " + zealot.getName() + "을 공격합니다. ");
        zealot.beAttacked(this.power);
    }

    // 2. 저글링이 마린을 공격합니다.
    public void attackMarine(Marine marine) {
        if (marine.getHp() <= 0) {
            System.out.println(this.name + "이 이미 사망하여 공격할 수 없습니다.");
            return;
        }
        System.out.print(this.name + "이 " + marine.getName() + "을 공격합니다. ");
        marine.beAttacked(this.power);
    }

    // 3. 자기 자신(저글링)이 공격을 당합니다.
    public void beAttacked(int power) {
        if (this.hp <= 0) {
            System.out.println(this.name + " 은 이미 사망한 상태입니다.");
        } else {
            this.hp -= power;
            System.out.println(this.name + "이 공격을 당합니다.");
            if (this.hp <= 0) {
                this.hp = 0;
                System.out.println(this.name + " 은 사망했습니다.");
            }
        }
    }

    // 4. 내 현재 상태 출력 기능 만들기
    public void showInfZergling() {
        System.out.println("\n === 저글링 상태창 ===");
        System.out.println("이름: " + name);
        System.out.println("공격력: " + power);
        System.out.println("현재 체력: " + hp);
        System.out.println();
    }
}
