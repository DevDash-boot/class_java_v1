package useful.ch07;

public class Powder extends Material {
    @Override
    public String toString() {
        return "재료는 파우더 입니다.";
    }

    @Override
    public void showInfo() {
        System.out.println("재료는 파우더");
    }
}
