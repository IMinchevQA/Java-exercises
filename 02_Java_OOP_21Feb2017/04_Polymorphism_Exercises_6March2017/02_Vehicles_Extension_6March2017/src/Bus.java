public class Bus extends Vehicle {
    private final static double EXTRA_FUEL_CONSUMPTION = 1.4;

    public Bus (double fuelQuantity, double fuelConsumption, double fuelTankCapacity) {
        super(fuelQuantity, fuelConsumption, fuelTankCapacity);
    }

    public double getExtraFuelConsumption() {
        return EXTRA_FUEL_CONSUMPTION;
    }

    @Override
    protected void drive(double driveDistance) {
        double travelFuelNeeded = driveDistance * super.getFuelConsumption();
        if(super.getFuelQuantity() - travelFuelNeeded > 0) {
            super.setFuelQuantity(super.getFuelQuantity() - travelFuelNeeded);
            System.out.println(String.format("Bus travelled %s km", driveDistanceFormat(driveDistance)));
        } else {
            System.out.println("Bus needs refueling");
        }

    }

    private String driveDistanceFormat(double driveDistance) {
        int i = (int) driveDistance;
        return driveDistance == i ? String.valueOf(i) : String.valueOf(driveDistance);
    }

    @Override
    protected void refuel(double refuelQuantity) {
        if (super.getFuelQuantity() + refuelQuantity > super.getFuelTankCapacity()){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        super.setFuelQuantity(super.getFuelQuantity() + refuelQuantity);
    }

    @Override
    public String toString() {
        return String.format("Bus: %.2f", super.getFuelQuantity());
    }
}
