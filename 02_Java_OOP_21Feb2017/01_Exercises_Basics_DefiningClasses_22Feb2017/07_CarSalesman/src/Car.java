
public class Car {
    private String carModel;
    private String engine;
    private String weight = "n/a";
    private String color = "n/a";
    private Engine engineData;

    public Car (String model, String engine, Engine engineData) {
        this.carModel = model;
        this.engine = engine;
        this.engineData = engineData;
    }

    public String getCarModel() {
        return this.carModel;
    }

    public String getEngine() {
        return this.engine;
    }

    public String getWeight() {
        return this.weight;
    }

    public String getColor() {
        return this.color;
    }

    public void setWeight (String weight) {
        this.weight = weight;
    }

    public void setColor (String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        StringBuilder sbOutput = new StringBuilder();
        sbOutput.append(this.carModel + ":\n")
                .append("  " + this.engineData.getEngineModel() + ":\n")
                .append("    Power: " + this.engineData.getPower() + "\n")
                .append("    Displacement: " + this.engineData.getDisplacement() + "\n")
                .append("    Efficiency: " + this.engineData.getEfficiency() + "\n")
                .append("  Weight: " + this.weight + "\n")
                .append("  Color: " + this.color);
        return sbOutput.toString();

    }
}




