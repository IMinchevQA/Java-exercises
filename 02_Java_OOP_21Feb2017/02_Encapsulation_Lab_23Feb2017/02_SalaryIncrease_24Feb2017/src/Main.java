import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Person> personsList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        executeReadInput(n, reader);

        executeAddBonus(reader);

        executePrintResult();
    }

    private static void executePrintResult() {
        for (Person person : personsList) {
            System.out.println(person);
        }
    }

    private static void executeAddBonus(BufferedReader reader) throws IOException {
        int bonus = Integer.parseInt(reader.readLine());

        for (Person person : personsList) {
            person.increaseSalary(bonus);
        }
    }

    private static void executeReadInput(int n, BufferedReader reader) throws IOException {
        for (int i = 0; i < n; i++) {
            String[] personTokens = reader.readLine().trim().split("\\s+");
            String currentFirstName = personTokens[0];
            String currentlastName = personTokens[1];
            Integer currentAge = Integer.parseInt(personTokens[2]);
            Double currentSalary = Double.parseDouble(personTokens[3]);
            Person currentPerson = new Person(currentFirstName, currentlastName, currentAge, currentSalary);
            personsList.add(currentPerson);
        }
    }
}

/*
Input 1:
5
Asen Ivanov 65 2200
Boiko Borisov 57 3333
Ventsislav Ivanov 27 600
Asen Harizanoov 44 666.66
Boiko Angelov 35 559.4
20

Expected output 1:
Asen Ivanov get 2640.0 leva
Boiko Borisov get 3999.6 leva
Ventsislav Ivanov get 660.0 leva
Asen Harizanoov get 799.992 leva
Boiko Angelov get 671.28 leva


 */
