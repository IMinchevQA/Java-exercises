import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        List<Car> carList = new ArrayList<>();


        while (n-- > 0) {
            String carData[] = reader.readLine().split("\\s+");
            Car car = null;
            String model = carData[0];
            int engineSpeed = Integer.parseInt(carData[1]);
            int enginePower = Integer.parseInt(carData[2]);
            Engine engine = new Engine(engineSpeed, enginePower);

            int cargoWeight = Integer.parseInt(carData[3]);
            String cargoType = carData[4];
            Cargo cargo = new Cargo(cargoType, cargoWeight);

            List<Tire> tires = new ArrayList<>();
            for (int i = 5; i < carData.length - 1; i+= 2) {
                double pressure = Double.parseDouble(carData[i]);
                int age = Integer.parseInt(carData[i + 1]);
                Tire tire = new Tire(age, pressure);
                tires.add(tire);

            }
            car = new Car(model, engine, cargo, tires);
            carList.add(car);
        }

        String command = reader.readLine();
        switch (command) {
            case "fragile":
                carList.stream()
                        .filter(car -> car.getTires().stream()
                                //filter all tires with pressure < 1
                                .filter(tire -> tire.getPressure() < 1)

                                //returns a list only if there is at least 1 tire with pressure < 1;
                        .collect(Collectors.toList()).size() > 0)

                        //filter only cars with cargo type - fragile
                        .filter(car -> car.getCargo().getType().equals(command))

                        //print the result
                        .forEach(System.out::println);
                break;
            case "flamable":
                carList.stream()
                        .filter(car -> car.getEngine().getPower() > 250)
                        .filter(car -> (car.getCargo().getType()).equals(command))
                        .forEach(System.out::println);

                break;
        }


    }
}

/*
Input 1:
2
ChevroletAstro 200 180 1000 fragile 1.3 1 1.5 2 1.4 2 1.7 4
Citroen2CV 190 165 1200 fragile 0.9 3 0.85 2 0.95 2 1.1 1
fragile

Expected output 1:
Citroen2CV


Input 2:
4
ChevroletExpress 215 255 1200 flamable 2.5 1 2.4 2 2.7 1 2.8 1
ChevroletAstro 210 230 1000 flamable 2 1 1.9 2 1.7 3 2.1 1
DaciaDokker 230 275 1400 flamable 2.2 1 2.3 1 2.4 1 2 1
Citroen2CV 190 165 1200 fragile 0.8 3 0.85 2 0.7 5 0.95 2
flamable


Expected output 2:
ChevroletExpress
DaciaDokker


 */


