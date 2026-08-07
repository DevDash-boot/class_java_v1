package exercise.Exercise8_2;

public class PartTimeEmployee extends Employee {

    private int hourlyWage;
    private int workHours;

    public PartTimeEmployee(String name, int id, int hourlyWage, int workHours) {
        super(name, id);
        this.hourlyWage = hourlyWage;
        this.workHours = workHours;
    }

    @Override
    public int calculatePay() {
        return this.hourlyWage * this.workHours;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("이번 달 근무 시간: " + this.workHours);
        System.out.println("급여: " + this.hourlyWage * this.workHours);
    }
}
