package Ex01_DefineAnInterfacePerson_15March2017;

public class Citizen implements Person {
    private String name;
    private Integer age;

    public Citizen (String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
