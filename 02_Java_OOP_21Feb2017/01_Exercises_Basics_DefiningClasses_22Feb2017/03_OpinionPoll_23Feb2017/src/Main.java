import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.util.*;

/**
 * Created by Ivan Minchev on 2/23/2017.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Class personClass = Person.class;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Constructor personCtor = personClass.getConstructor(int.class, String.class);
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split("\\s+");
            String name = line[0];
            int age =  Integer.parseInt(line[1]);

            if (age > 30) {
                Person person = (Person) personCtor.newInstance(age, name);
                persons.add(person);
            }
        }

        List<Person> personsSorted = new ArrayList<>();
        persons.stream().sorted((person1, person2) -> person1.name.compareTo(person2.name))
        .forEachOrdered((person) -> personsSorted.add(person));

        personsSorted.stream().forEach((person) -> System.out.printf("%s - %s%n", person.name, person.age));
    }
}

class Person {
    String name;
    int age;

    public Person (int age, String name) {
        this.age = age;
        this.name = name;
    }
}

/*
Input 1:
3
Pesho 12
Stamat 31
Ivan 48

Expected output 1:
Ivan - 48
Stamat - 31



Input 2:
5
Nikolai 33
Yordan 88
Tosho 22
Lyubo 44
Stanislav 11

Expected output 2:
Lyubo - 44
Nikolai - 33
Yordan - 88


 */