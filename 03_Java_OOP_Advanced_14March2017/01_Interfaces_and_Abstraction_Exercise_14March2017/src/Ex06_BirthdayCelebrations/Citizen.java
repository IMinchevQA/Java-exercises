package Ex06_BirthdayCelebrations;

public class Citizen implements Identifiable, Birthable {
    private String name;
    private String age;
    private String id;
    private String birthday;

    public Citizen (String name, String age, String id, String birthday) {
        this.setName(name);
        this.setAge(age);
        this.setId(id);
        this.setBirthday(birthday);
    }

    @Override
    public String getName() {
        return this.name;
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

    @Override
    public String getBirthday() {
        return this.birthday;
    }

    private void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
