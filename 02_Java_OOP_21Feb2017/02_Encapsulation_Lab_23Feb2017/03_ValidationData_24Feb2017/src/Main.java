import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Person> personsList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        executeFillPersonsList(n, reader);

        if (!personsList.isEmpty() && personsList.size() != n) {
            System.out.println("--------------------");
        }

        executeAddBonusAndPrint(reader);

    }



    private static void executeAddBonusAndPrint(BufferedReader reader) throws IOException {
        Double bonus = Double.parseDouble(reader.readLine().trim());

        for (Person person : personsList) {
            person.increaseSalary(bonus);
            System.out.println(person);
        }
    }

    private static void executeFillPersonsList(int n, BufferedReader reader) throws IOException {

            for (int i = 0; i < n; i++) {
                String[] personTokens = reader.readLine().trim().split("\\s+");
            try {
                String currentFirstName = personTokens[0];
                String currentlastName = personTokens[1];
                Integer currentAge = Integer.parseInt(personTokens[2]);
                Double currentSalary = Double.parseDouble(personTokens[3]);
                Person currentPerson = new Person(currentFirstName, currentlastName, currentAge, currentSalary);
                personsList.add(currentPerson);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
    }
}

/*
Input 1:
5
Asen Ivanov -6 2200
B Borisov 57 3333
Ventsislav Ivanov 27 600
Asen H 44 666.66
Boiko Angelov 35 300
20


Expected output 1:
Age cannot be zero or negative integer
First name cannot be less than 3 symbols
Last name cannot be less than 3 symbols
Salary cannot be less than 460 leva
--------------------
Ventsislav Ivanov get 660.0 leva


 */
