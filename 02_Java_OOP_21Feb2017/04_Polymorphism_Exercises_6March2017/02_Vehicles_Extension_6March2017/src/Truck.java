/**
 * Created by Ivan Minchev on 3/6/2017.
 */
public class Truck extends Vehicle {
    //Extra consumption due to the air conditioner.
    private static final double EXTRA_FUEL_CONSUMPTION = 1.6;

    public Truck(double fuelQuantity, double fuelConsumption, double fuelTankCapacity) {
        super(fuelQuantity, fuelConsumption + EXTRA_FUEL_CONSUMPTION, fuelTankCapacity);
    }


    @Override
    protected void drive(double driveDistance) {
        double travelFuelNeeded = driveDistance * super.getFuelConsumption();
        if(super.getFuelQuantity() - travelFuelNeeded > 0) {
            super.setFuelQuantity(super.getFuelQuantity() - travelFuelNeeded);            
            System.out.println(String.format("Truck travelled %s km", driveDistanceFormat(driveDistance)));
        } else {
            System.out.println("Truck needs refueling");
        }

    }

    private String driveDistanceFormat(double driveDistance) {
        int i = (int) driveDistance;
        return driveDistance == i ? String.valueOf(i) : String.valueOf(driveDistance);
    }

    @Override
    protected void refuel(double refuelQuantity) {
        super.setFuelQuantity(super.getFuelQuantity() + (refuelQuantity * 0.95));
    }

    @Override
    public String toString() {
        return String.format("Truck: %.2f", super.getFuelQuantity());
    }

}
