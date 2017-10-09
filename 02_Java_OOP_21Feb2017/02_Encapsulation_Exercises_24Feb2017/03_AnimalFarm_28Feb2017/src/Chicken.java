
public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name.equals(null) || name.equals("") || name.equals(" ")) {
            throw new NullPointerException("Name cannot be empty.");
        }
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }


    private void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    @Override
    public String toString() {
        if (this.getAge() < 6) {
            return String.format("Chicken %s (age %d) can produce 2 eggs per day.", this.getName(), this.getAge());
        } else if (this.getAge() < 12) {
            return String.format("Chicken %s (age %d) can produce 1 eggs per day.", this.getName(), this.getAge());
        }
        return String.format("Chicken %s (age %d) can produce 0.75 eggs per day.", this.getName(), this.getAge());
    }
}
