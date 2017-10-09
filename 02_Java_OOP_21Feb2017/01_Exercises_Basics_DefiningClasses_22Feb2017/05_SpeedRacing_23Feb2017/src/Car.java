/**
 * Created by Ivan Minchev on 2/23/2017.
 */
public class Car {
    private String model;
    private double amountOfFuel;
    private double fuelConsumption;
    private int distanceTraveled;

    public Car (String model, double amountOfFuel, double fuelConsumption) {
        this.model = model;
        this.amountOfFuel = amountOfFuel;
        this.fuelConsumption = fuelConsumption;
        this.distanceTraveled = 0;
    }

    public String getModel() {
        return this.model;
    }

    public double getAmountOfFuel() {
        return this.amountOfFuel;
    }

    public double getFuelConsumption() {
        return this.fuelConsumption;
    }

    public int getDistanceTraveled() {
        return this.distanceTraveled;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setAmountOfFuel(double amountOfFuel) {
        this.amountOfFuel = amountOfFuel;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void setDistanceTraveled(int distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public void Drive (int distance) {
        if (distance * this.fuelConsumption <= this.amountOfFuel) {
            this.distanceTraveled += distance;
            this.amountOfFuel -= distance * this.fuelConsumption;
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }
}
