package Ex05_BorderControl;

public class Citizen implements Controllable {
    private String name;
    private String age;
    private String id;

    public Citizen (String name, String age, String id) {
        this.setName(name);
        this.setAge(age);
        this.setId(id);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getModel() {
        return null;
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAge() {
        return this.age;
    }

    private void setAge(String age) {
        this.age = age;
    }

    @Override
    public String getId() {
        return this.id;
    }

    private void setId(String id) {
        this.id = id;
    }
}
