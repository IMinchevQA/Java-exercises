package Ex06_BirthdayCelebrations;

public class Robot implements Identifiable {
    private String model;
    private String id;

    public Robot (String model, String id) {
        this.setName(model);
        this.setId(id);
    }

    @Override
    public String getName() {
        return null;
    }

    public void setName(String name) {
        this.model = name;
    }

    @Override
    public String getAge() {
        return null;
    }

    @Override
    public String getId() {
        return null;
    }

    public void setId(String id) {
        this.id = id;
    }
}
