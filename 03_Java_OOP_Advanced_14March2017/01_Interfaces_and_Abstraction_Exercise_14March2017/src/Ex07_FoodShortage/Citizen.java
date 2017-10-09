package Ex07_FoodShortage;

public class Citizen implements Buyer {
    private String name;
    private String age;
    private String id;
    private String birthday;
    private int food;

    public Citizen (String name, String age, String id, String birthday) {
        this.setName(name);
        this.setAge(age);
        this.setId(id);
        this.setBirthday(birthday);
    }


    private void setName(String name) {
        this.name = name;
    }

    private void setAge(String age) {
        this.age = age;
    }


    private void setId(String id) {
        this.id = id;
    }

    private void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public int getFood() {
        return this.food;
    }

    @Override
    public void buyFood() {
        this.food += 10;
    }

}
