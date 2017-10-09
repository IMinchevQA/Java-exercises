package Ex07_FoodShortage;


public class Rebel implements Buyer {
    private String name;
    private String age;
    private String group;
    private int food;

    public Rebel (String name, String age, String group) {
        this.setName(name);
        this.setAge(age);
        this.setGroup(group);
    }


    @Override
    public int getFood() {
        return this.food;
    }

    @Override
    public void buyFood() {
        this.food += 5;
    }

    private void setName(String name) {
        this.name = name;
    }


    private void setAge(String age) {
        this.age = age;
    }

    private void setGroup(String group) {
        this.group = group;
    }
}
