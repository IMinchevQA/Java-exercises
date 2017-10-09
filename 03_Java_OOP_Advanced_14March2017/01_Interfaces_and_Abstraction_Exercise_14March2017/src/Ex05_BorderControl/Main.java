package Ex05_BorderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Controllable> robotsAndCitizens = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        executeReadInputData(reader);

        String fakeId = reader.readLine();
        executeFakeIdCheck(fakeId);
//        robotsAndCitizens.stream().filter(e -> e.getId().endsWith(fakeId)).forEach(p -> System.out.println(p.getId()));
    }

    private static void executeFakeIdCheck(String fakeId) {
        for (Controllable robotOrCitizen : robotsAndCitizens) {
            String currentId = robotOrCitizen.getId();

            //Check if there is a fake id at the end of the currentId
            if (currentId.substring(currentId.length() - fakeId.length()).equals(fakeId)) {
                System.out.println(robotOrCitizen.getId());
            }
        }
    }

    private static void executeReadInputData(BufferedReader reader) throws IOException {
        String inputLine = "";
        while (!"End".equals(inputLine = reader.readLine())) {
            String[] lineTokens = inputLine.split("\\s+");
            if (lineTokens.length == 2) {
                String model = lineTokens[0];
                String id = lineTokens[1];
                Controllable robot = new Robot(model, id);
                robotsAndCitizens.add(robot);
            }

            if (lineTokens.length == 3) {
                String name = lineTokens[0];
                String age = lineTokens[1];
                String id = lineTokens[2];
                Controllable citizen = new Citizen(name, age, id);
                robotsAndCitizens.add(citizen);
            }
        }
    }
}

/*
Input 1:
Pesho 22 9010101122
MK-13 558833251
MK-12 33283122
Pesho 32 122122
End
122

Expected output 1:
9010101122
33283122
122122




Input 2:
Toncho 31 7801211340
Penka 29 8007181534
IV-228 999999
Stamat 54 3401018380
KKK-666 80808080
End
340

Expected output 2:
7801211340
 */
