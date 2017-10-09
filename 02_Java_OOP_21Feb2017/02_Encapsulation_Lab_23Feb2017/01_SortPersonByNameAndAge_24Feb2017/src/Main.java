import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            persons.add(new Person(input[0], input[1], Integer.parseInt(input[2])));
        }

        Collections.sort(persons, (firstPerson, secondPerson) -> {
            int sComp = firstPerson.getFirstName().compareTo(secondPerson.getFirstName());
            if (sComp != 0) {
                return sComp;
            } else {
                return firstPerson.getAge().compareTo(secondPerson.getAge());
            }
        });

        for (Person person : persons) {
            System.out.println(person.toString());
        }

    }
}

/*
Input 1:
5
Asen Ivanov 65
Boiko Borisov 57
Ventsislav Ivanov 27
Asen Harizanoov 44
Boiko Angelov 35

Expected output 1:
Asen Harizanoov is a 44 years old.
Asen Ivanov is a 65 years old.
Boiko Angelov is a 35 years old.
Boiko Borisov is a 57 years old.
Ventsislav Ivanov is a 27 years old.




 */

