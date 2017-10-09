package Ex06_StrategyPattern;


public class PersonImpl implements Comparable, Person {
    private String name;
    private int age;

    public PersonImpl(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.getName(), this.getAge());
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
