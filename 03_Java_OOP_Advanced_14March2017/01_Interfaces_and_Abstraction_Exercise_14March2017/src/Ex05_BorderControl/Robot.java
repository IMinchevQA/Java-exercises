package Ex05_BorderControl;


public class Robot implements Controllable {
    private String model;
    private String id;

    public Robot (String model, String id) {
        this.setModel(model);
        this.setId(id);
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getAge() {
        return null;
    }

    private void setModel(String model) {
        this.model = model;
    }

    @Override
    public String getId() {
        return this.id;
    }

    private void setId(String id) {
        this.id = id;
    }

}
