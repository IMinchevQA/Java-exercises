package livedemo;

public class Person extends Citizen {
    private static final int DEFAULT_AGE = 0;
    private static final String DEFAULT_NAME = "Pesho";
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Person(String age) {
        this.name = name;
        this.age = DEFAULT_AGE;
    }

    public Person() {
        this.name = DEFAULT_NAME;
        this.age = DEFAULT_AGE;
    }
}
