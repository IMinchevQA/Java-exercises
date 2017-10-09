import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static List<Engine> enginesList = new ArrayList<>();
    public static List<Car> carsList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        executeReadEngines(n, reader);

        int m = Integer.parseInt(reader.readLine());
        executeReadCars(m, reader);

        for (Car car : carsList) {
            System.out.println(car);
        }

    }

    private static void executeReadCars(int m, BufferedReader reader) throws IOException {
        for (int i = 0; i < m; i++) {
            String[] carTokens = reader.readLine().trim().split("\\s+");
            String modelCurrenCar = carTokens[0];
            String engineCurrentCar = carTokens[1];
            Engine engineData = enginesList.stream().filter(e -> (e.getEngineModel()).equals(engineCurrentCar))
                    .collect(Collectors.toList()).get(0);

            Car currentCar = new Car(modelCurrenCar, engineCurrentCar, engineData);

            if (carTokens.length == 3) {
                if (Character.isLetter(carTokens[2].charAt(0))) {
                    currentCar.setColor(carTokens[2]);
                } else {
                    currentCar.setWeight(carTokens[2]);
                }
            } else if (carTokens.length == 4) {
                currentCar.setWeight(carTokens[2]);
                currentCar.setColor(carTokens[3]);
            }
            carsList.add(currentCar);
        }
    }

    private static void executeReadEngines(int n, BufferedReader reader) throws IOException {
        for (int i = 0; i < n; i++) {
            String[] engineTokens = reader.readLine().trim().split("\\s+");
            String engineModel = engineTokens[0];
            String enginePower = engineTokens[1];
            Engine currentEngine = new Engine (engineModel, enginePower);

            if (engineTokens.length == 3) {
                if (Character.isLetter(engineTokens[2].charAt(0))) {
                    currentEngine.setEfficiency(engineTokens[2]);
                } else {
                    currentEngine.setDisplacement(engineTokens[2]);
                }
            } else if (engineTokens.length == 4) {
                currentEngine.setDisplacement(engineTokens[2]);
                currentEngine.setEfficiency(engineTokens[3]);
            }
            enginesList.add(currentEngine);
        }
    }
}

/*
Input 1:
2
V8-101 220 50
V4-33 140 28 B
3
FordFocus V4-33 1300 Silver
FordMustang V8-101
VolkswagenGolf V4-33 Orange

Expected output 1:
V8-101 220 50
V4-33 140 28 B
3
FordFocus V4-33 1300 Silver
FordMustang V8-101
VolkswagenGolf V4-33 Orange


Input 2:
4
DSL-10 280 B
V7-55 200 35
DSL-13 305 55 A+
V7-54 190 30 D
4
FordMondeo DSL-13 Purple
VolkswagenPolo V7-54 1200 Yellow
VolkswagenPassat DSL-10 1375 Blue
FordFusion DSL-13

Expected output 2:
FordMondeo:
  DSL-13:
    Power: 305
    Displacement: 55
    Efficiency: A+
  Weight: n/a
  Color: Purple
VolkswagenPolo:
  V7-54:
    Power: 190
    Displacement: 30
    Efficiency: D
  Weight: 1200
  Color: Yellow
VolkswagenPassat:
  DSL-10:
    Power: 280
    Displacement: n/a
    Efficiency: B
  Weight: 1375
  Color: Blue
FordFusion:
  DSL-13:
    Power: 305
    Displacement: 55
    Efficiency: A+
  Weight: n/a
  Color: n/a


 */
