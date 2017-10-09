/**
 * Created by Ivan Minchev on 2/24/2017.
 */
public class Engine {
    private String engineModel;
    private String power;
    private String displacement = "n/a";
    private String efficiency = "n/a";


    public Engine (String engineModel, String power) {
        this.engineModel = engineModel;
        this.power = power;
    }

    public String getEngineModel() {
        return this.engineModel;
    }

    public String getPower() {
        return this.power;
    }

    public String getDisplacement() {
        return this.displacement;
    }

    public String getEfficiency() {
        return this.efficiency;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }
}
