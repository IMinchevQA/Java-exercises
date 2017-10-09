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

        Team team = new Team("Minior Pernik");

        for (Person person : personsList) {
            team.addPlayer(person);
        }

        System.out.printf("First team have " + team.getFirstTeam().size() + " players%n");
        System.out.printf("Reserve team have " + team.getReserveTeam().size() + " players%n");

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
Asen Ivanov 20 2200
Boiko Borisov 57 3333
Ventsislav Ivanov 27 600
Grigor Dimitrov 25 666.66
Boiko Angelov 35 555

Expected output 1:
First team have 4 players
Reserve team have 1 players


 */