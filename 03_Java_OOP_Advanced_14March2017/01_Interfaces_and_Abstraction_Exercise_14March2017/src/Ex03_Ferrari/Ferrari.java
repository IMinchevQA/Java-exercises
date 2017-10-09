package Ex03_Ferrari;

public class Ferrari implements Car {
    private static final String model = "488-Spider";
    private String driverName;

    public Ferrari(String driverName) {
        this.setDriverName(driverName);
    }

    @Override
    public String getName() {
        return this.driverName;
    }

    private void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String gasPedal() {
        return "Zadu6avam sA!";
    }

    @Override
    public String getModel() {
        return this.model;
    }
}
