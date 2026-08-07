package exercise.Exercise8_instruoctor_2;

public class FullTimeEmployee extends Employee {

    private int monthlySalary;

    public FullTimeEmployee(String name, int id, int monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public int calculatePay() {
        return monthlySalary;
    }

}