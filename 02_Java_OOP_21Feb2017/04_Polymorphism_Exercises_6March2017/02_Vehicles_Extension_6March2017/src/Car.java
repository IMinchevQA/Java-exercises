
public class Car extends Vehicle {
    //Extra consumption due to the air conditioner.
    private static final double EXTRA_FUEL_CONSUMPTION = 0.9;

    public Car (double fuelQuantity, double fuelConsumption, double fuelTankCapacity) {
        super(fuelQuantity, fuelConsumption + EXTRA_FUEL_CONSUMPTION, fuelTankCapacity);
    }



    @Override
    protected void drive(double driveDistance) {
        double travelFuelNeeded = driveDistance * super.getFuelConsumption();
        if(super.getFuelQuantity() - travelFuelNeeded > 0) {
            super.setFuelQuantity(super.getFuelQuantity() - travelFuelNeeded);
            System.out.println(String.format("Car travelled %s km", driveDistanceFormat(driveDistance)));
        } else {
            System.out.println("Car needs refueling");
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
        return String.format("Car: %.2f", super.getFuelQuantity());
    }
}
