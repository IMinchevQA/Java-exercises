package Ex06_BirthdayCelebrations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
        static List<Birthable> entities = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        executeReadInputData(reader);

        String searchBirthday = reader.readLine();
        executeBirthdayCheck(searchBirthday);
    }

    private static void executeBirthdayCheck(String searchBirthday) {

        for(Birthable entity : entities) {
            String currentBirthday = entity.getBirthday();

            if (currentBirthday.substring(currentBirthday.length() - searchBirthday.length()).equals(searchBirthday)) {
                System.out.println(currentBirthday);
            }
        }
    }

    private static void executeReadInputData(BufferedReader reader) throws IOException {
        String inputLine = "";

        while (!"End".equals(inputLine = reader.readLine())) {
            String[] lineTokens = inputLine.split("\\s+");
            switch (lineTokens[0].toLowerCase()) {
                case "citizen":
                    String citizenName = lineTokens[1];
                    String citizenAge = lineTokens[2];
                    String citizenId = lineTokens[3];
                    String citizenBirthdate = lineTokens[4];
                    Birthable citizen = new Citizen(citizenName, citizenAge, citizenId, citizenBirthdate);
                    entities.add(citizen);
                    break;
                case "pet":
                    String petName = lineTokens[1];
                    String petBirthdate = lineTokens[2];
                    Birthable pet = new Pet(petName, petBirthdate);
                    entities.add(pet);
                    break;
            }
        }
    }
}


/*
Input 1:
Citizen Pesho 22 9010101122 10/10/1990
Pet Sharo 13/11/2005
Robot MK-13 558833251
End
1990


Expected output 1:
10/10/1990


Input 2:
Citizen Stamat 16 0041018380 01/01/2000
Robot MK-10 12345678
Robot PP-09 00000001
Pet Topcho 24/12/2000
Pet Kosmat 12/06/2002
End
2000


Expected output 2:
01/01/2000
24/12/2000

 */
