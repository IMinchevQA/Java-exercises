import com.sun.org.apache.regexp.internal.RE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static Vehicle car = null;
    public static Vehicle truck = null;
    public static Vehicle bus = null;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        Vehicle car = new Car(15, 0.3);
//        car.drive(9);
//        car.drive(30);
//        car.refuel(50);
//        car.drive(30);
//        System.out.println();

        for (int createVehicle = 0; createVehicle < 3; createVehicle++) {
            createVehicles(reader);
        }

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            try {
                executeCommand(reader);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);


    }

    private static void executeCommand(BufferedReader reader) throws IOException {
        String[] commandTokens = reader.readLine().trim().split("\\s+");
        String command = commandTokens[0];
        String vehicleType = commandTokens[1];
        switch(command.toLowerCase()) {
            case "drive":
                double driveDistance = Double.parseDouble(commandTokens[2]);
                switch(vehicleType.toLowerCase()) {
                    case "car":
                        car.drive(driveDistance);
                        break;
                    case "truck":
                        truck.drive(driveDistance);
                        break;
                    case "bus":
                        bus.setFuelConsumption(bus.getFuelConsumption() + ((Bus)bus).getExtraFuelConsumption());
                        bus.drive(driveDistance);
                }
                break;
            case "refuel":
                double refuelQuantity = Double.parseDouble(commandTokens[2]);
                switch(vehicleType.toLowerCase()) {
                    case "car":
                        car.refuel(refuelQuantity);
                        break;
                    case "truck":
                        truck.refuel(refuelQuantity);
                        break;
                    case "bus":
                        bus.refuel(refuelQuantity);
                        break;
                }
                break;
            case "driveempty":
                bus.drive(Double.parseDouble(commandTokens[2]));
                break;
        }

    }

    public static void createVehicles(BufferedReader reader) throws IOException {
        String[] vehicleTokens = reader.readLine().trim().split("\\s+");
        String vehicleType = vehicleTokens[0];
        double fuelQuantity = Double.parseDouble(vehicleTokens[1]);
        double fuelConsumption = Double.parseDouble(vehicleTokens[2]);
        double fuelTankCapacity = Double.parseDouble(vehicleTokens[3]);
        switch(vehicleType.toLowerCase()) {
            case "car":
                car = new Car(fuelQuantity, fuelConsumption, fuelTankCapacity);
                break;
            case "truck":
                truck = new Truck(fuelQuantity, fuelConsumption, fuelTankCapacity);
                break;
            case "bus":
                bus = new Bus(fuelQuantity, fuelConsumption, fuelTankCapacity);
                break;
        }
    }
}



/*
Input TEST
Car 30 0.04 70
Truck 100 0.5 300
5
Refuel Car -10
Refuel Truck 0
Refuel Car 10
Refuel Car 300
Refuel Truck 1000


Input 1:
Car 15 0.3
Truck 100 0.9
4
Drive Car 9
Drive Car 30
Refuel Car 50
Drive Truck 10

Expected output 1:
Car travelled 9 km
Car needs refueling
Truck travelled 10 km
Car: 54.20
Truck: 75.00


Input 2:
Car 30.4 0.4
Truck 99.34 0.9
5
Drive Car 500
Drive Car 13.5
Refuel Truck 10.300
Drive Truck 56.2
Refuel Car 100.2

Expected output 2:
Car needs refueling
Car travelled 13.5 km
Truck needs refueling
Car: 113.05
Truck: 109.13

 */
