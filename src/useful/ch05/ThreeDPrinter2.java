package useful.ch05;

public class ThreeDPrinter2 {

    // 재료
    Powder material;

    // 재료를 꺼냄
    public Powder getMaterial() {
        return material;
    }

    // 재료를 넣음
    public void setMaterial(Powder material) {
        this.material = material;
    }

    public static void main(String[] args) {
        Powder powder1 = new Powder();
        ThreeDPrinter2 threeDPrinter1 = new ThreeDPrinter2();
        threeDPrinter1.setMaterial(powder1);

        System.out.println(threeDPrinter1.getMaterial());
    }
}
