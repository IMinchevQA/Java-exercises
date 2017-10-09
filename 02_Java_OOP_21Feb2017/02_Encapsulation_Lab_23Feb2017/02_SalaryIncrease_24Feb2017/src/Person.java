
public class Person {
    private String firstName;
    private String lastName;
    private Integer age;
    private Double salary;

    public Person (String firstName, String lastName, Integer age, Double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String name) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }


    public void increaseSalary(int bonusPercentage) {
        if (this.getAge() < 30) {
            // bonusPercentage / 200 is half a bonus.
            this.salary += (double)bonusPercentage / 200 * this.salary;
        } else {
            this.salary += (double)bonusPercentage / 100 * this.salary;
        }
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName + " get " + this.salary + " leva";
    }
}
