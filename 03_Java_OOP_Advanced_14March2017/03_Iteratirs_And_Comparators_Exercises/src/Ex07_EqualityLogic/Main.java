package Ex07_EqualityLogic;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Set<Person> personsTreeSet = new TreeSet<>();
        Set<Person> personsHashSet = new HashSet<>();
        String[] lineTokens;
        String name;
        int age;

        for (int i = 0; i < n; i++) {
            lineTokens = reader.readLine().split("\\s+");
            name = lineTokens[0];
            age = Integer.parseInt(lineTokens[1]);

            Person person = new PersonImpl(name, age);
            personsTreeSet.add(person);
            personsHashSet.add(person);
        }

        System.out.println(personsTreeSet.size());
        System.out.println(personsHashSet.size());
    }
}

/*
Input 1:
4
Pesho 20
Peshp 20
Joro 15
Pesho 21

Expected output 1:
4
4


Input 2:
7
Ivan 17
ivan 17
Stoqn 25
Ivan 18
Ivan 17
Stopn 25
Stoqn 25

Expected output 2
5
5

 */
