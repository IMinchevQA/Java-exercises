
public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private double fuelTankCapacity;


    public Vehicle(double fuelQuantity, double fuelConsumption, double fuelTankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.fuelConsumption = fuelConsumption;
        this.fuelTankCapacity = fuelTankCapacity;
    }

    public double getFuelQuantity() {
        return this.fuelQuantity;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity < 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelTankCapacity() {
        return this.fuelTankCapacity;
    }

    public double getFuelConsumption() {
        return this.fuelConsumption;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    protected abstract void drive(double driveDistance);

    protected abstract void refuel(double refuelQuantity);

    public abstract String toString();


}
