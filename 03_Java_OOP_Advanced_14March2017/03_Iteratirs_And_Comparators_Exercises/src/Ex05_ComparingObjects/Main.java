package Ex05_ComparingObjects;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Person> persons = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        executeReadInputAndPerformCommands(reader);

        executeComparison(reader);
    }

    private static void executeComparison(BufferedReader reader) throws IOException {
        int indexNthPerson = Integer.parseInt(reader.readLine());
        int cntEqualPersons = 0;

        Person comparisonPerson = persons.get(indexNthPerson - 1);

        for(Person person : persons) {
            if(person.compareTo(comparisonPerson) == 0) {
                cntEqualPersons++;
            }
        }

        if (cntEqualPersons == 1) {
            System.out.println("No matches");
        } else {
            int differentPersons = persons.size() - cntEqualPersons;
            System.out.printf("%s %s %s%n", cntEqualPersons, differentPersons, persons.size());
        }
    }

    private static void executeReadInputAndPerformCommands (BufferedReader reader) throws IOException {
        String line = "";

        while(!"END".equals(line = reader.readLine())) {
            String[] lineTokens = line.split("\\s+");

            String name = lineTokens[0];
            int age = Integer.parseInt(lineTokens[1]);
            String town = lineTokens[2];

            Person currentPerson = new Person(name, age, town);
            persons.add(currentPerson);
        }
    }
}


/*
Input 1:
Pesho 22 Vraca
Gogo 14 Sofeto
END
2

Expected output 1:
No matches


Input 2:
Pesho 22 Vraca
Gogo 22 Vraca
Gogo 22 Vraca
END
2

Expected output 2:
2 1 3

 */