package exercise.Exercise8_instruoctor_2;

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
        return hourlyWage * workHours;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        // name 은 private 이므로 자식에서는 getName() 으로 읽는다
        System.out.println(getName() + " 님의 이번 달 근무 시간 : " + workHours + "시간");
    }

}
