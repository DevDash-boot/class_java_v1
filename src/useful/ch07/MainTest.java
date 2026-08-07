package useful.ch07;

public class MainTest {
    public static void main(String[] args) {

        Water water = new Water();
        Plastic plastic = new Plastic();

        GenericPrinter printer = new GenericPrinter();
        // printer.setMaterial(water); // 제네릭의 범위에 제한이 없기 때문에 무엇이든 들어갈 수 있다.

        printer.setMaterial(plastic);
        System.out.println(printer.getMaterial());



    }
}
