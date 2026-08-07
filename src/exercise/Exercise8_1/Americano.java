package exercise.Exercise8_1;

public class Americano extends Beverage{
    public Americano(String name, int price) {
        super(name, price);
    }

    @Override
    public void prepare() {
        System.out.println(super.getName() + "에 물을 붓습니다.");
        System.out.println(super.getName() + " 나왔습니다. 가격은 " + super.getPrice() + "원 입니다.");
        System.out.println("------------");
    }

}
