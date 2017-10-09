import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Car> carsList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        executeFillCarsList(n, reader);

        executeDrive(reader);

        executePrint();
    }

    private static void executePrint() {
        for (Car car : carsList) {
            System.out.printf("%s %.2f %s%n", car.getModel(), car.getAmountOfFuel(), car.getDistanceTraveled());
        }
    }

    private static void executeDrive(BufferedReader reader) throws IOException {
        String line;

        while(!"End".equals(line = reader.readLine())) {
            String[] tokens = line.trim().split("\\s+");
            String model = tokens[1];
            int distance = Integer.parseInt(tokens[2]);

            for (Car car : carsList) {
                if (car.getModel().equals(model)) {
                    car.Drive(distance);
                }
            }
        }
    }

    private static void executeFillCarsList(int n, BufferedReader reader) throws IOException {
        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().trim().split("\\s+");
            String model = tokens[0];
            double amountOfFuel = Double.parseDouble(tokens[1]);
            double fuelConsumption = Double.parseDouble(tokens[2]);
            Car car = new Car(model, amountOfFuel, fuelConsumption);
            carsList.add(car);
        }
    }
}

/*
Input 1:
2
AudiA4 23 0.3
BMW-M2 45 0.42
Drive BMW-M2 56
Drive AudiA4 5
Drive AudiA4 13
End

Expected output 1:
AudiA4 17.60 18
BMW-M2 21.48 56



Input 2:
3
AudiA4 18 0.34
BMW-M2 33 0.41
Ferrari-488Spider 50 0.47
Drive Ferrari-488Spider 97
Drive Ferrari-488Spider 35
Drive AudiA4 85
Drive AudiA4 50
End


Expected output 2:
Account ID1 created
Account ID2 created
Deposited 20 to ID1
Account does not exist
Insufficient fuel for the drive
Insufficient fuel for the drive
AudiA4 1.00 50
BMW-M2 33.00 0
Ferrari-488Spider 4.41 97


 */
