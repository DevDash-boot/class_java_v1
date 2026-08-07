package starcraft.ver_5;

public class GameTest{
    public static void main(String[] args) {

        Unit[] units = new Unit[6];
        units[0] = new Zealot("질럿1");
        units[1] = new Zealot("질럿2");
        units[2] = new Marine("마린1");
        units[3] = new Marine("마린2");
        units[4] = new Zergling("저글링1");
        units[5] = new Zergling("저글링2");

        units[0].attack(units[2]);
        units[1].move(5);
        units[1].stop();
        units[1].hold();

    }
}
