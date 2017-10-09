import java.util.IllegalFormatCodePointException;

/**
 * Created by Ivan Minchev on 3/2/2017.
 */
public class Worker extends Human {

    private double weekSalary;
    private double workHoursPerDay;

    public Worker (String firstName, String lastName, double weekSalary, double workHoursPerDay) {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkHoursPerDay(workHoursPerDay);

    }

    @Override
    protected void setLastName(String lastName) {
        if (lastName.length() < 4) {
            throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
        }
        super.setLastName(lastName);
    }

    private double getWeekSalary() {
        return this.weekSalary;
    }

    protected void setWeekSalary(double weekSalary) {
        if (weekSalary <= 10) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.weekSalary = weekSalary;
    }

    private double getWorkHoursPerDay() {
        return this.workHoursPerDay;
    }

    protected void setWorkHoursPerDay(double workHoursPerDay) {
        if (workHoursPerDay <= 1 || workHoursPerDay >= 12) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workHoursPerDay = workHoursPerDay;
    }

    private double calculateSalaryPerHour() {
        return this.getWeekSalary() / (this.getWorkHoursPerDay() * 7);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(String.format("Week Salary: %.2f%n", this.getWeekSalary()));
        sb.append(String.format("Hours per day: %.2f%n", this.getWorkHoursPerDay()));
        sb.append(String.format("Salary per hour: %.2f%n", this.calculateSalaryPerHour()));

        return sb.toString();
    }


}
