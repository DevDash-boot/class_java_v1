package exercise.Exercise8_3;

public class Manager extends FullTimeEmployee {

    private int allowance;

    public Manager(String name, int id, int monthlySalary, int allowance) {
        super(name, id, monthlySalary);
        this.allowance = allowance;
    }

    @Override
    public int calculatePay() {
        return super.calculatePay();
    }

    public int getAllowance() {
        return allowance;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("직책 수당: " + allowance + "원");
        System.out.println("급여: " + this.calculatePay()+ "원");
        System.out.println("보너스: " + this.calculateBonus()+ "원");
    }
}
