package Ex06_StrategyPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    TreeSet<Person> orderedByName = new TreeSet<>(new PersonNameComparator());
    TreeSet<Person> orderedByAge = new TreeSet<>(new PersonAgeComparator());

    int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] personTokens = reader.readLine().split("\\s+");
            String name = personTokens[0];
            int age = Integer.parseInt(personTokens[1]);
            Person person = new PersonImpl(name, age);
            orderedByName.add(person);
            orderedByAge.add(person);
        }

        orderedByName.forEach(System.out::println);
        orderedByAge.forEach(System.out::println);

    }
}



/*
Input 1:
3
Pesho 20
Joro 100
Pencho 1

Expected output 1:
Joro 100
Pesho 20
Pencho 1
Pencho 1
Pesho 20
Joro 100



Input 2:
5
Ivan 17
asen 33
Stoqn 25
Nasko 99
Joro 3


Expected output 2:
asen 33
Ivan 17
Joro 3
Nasko 99
Stoqn 25
Joro 3
Ivan 17
Stoqn 25
asen 33
Nasko 99

 */
