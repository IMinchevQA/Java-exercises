import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.lang.reflect.Constructor;

/**
 * Created by Ivan Minchev on 2/23/2017.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Class personClass = Person.class;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Constructor emptyCtor = personClass.getDeclaredConstructor();
        Constructor ageCtor = personClass.getDeclaredConstructor(int.class);
        Constructor nameAgeCtor = personClass.getDeclaredConstructor(int.class, String.class);

        String name = reader.readLine();
        int age = Integer.parseInt(reader.readLine());
        Person basePerson = (Person) emptyCtor.newInstance();
        Person personWithAge = (Person) ageCtor.newInstance(age);
        Person personWithNameAndAge = (Person) nameAgeCtor.newInstance(age, name);

        System.out.printf("%s %s%n", basePerson.name, basePerson.age);
        System.out.printf("%s %s%n", personWithAge.name, personWithAge.age);
        System.out.printf("%s %s%n", personWithNameAndAge.name, personWithNameAndAge.age);
    }
}

class Person {
    String name;
    int age;
    public Person () {
        this(1, "No name");
    }

    public Person (int age) {
        this(age, "No name");
    }

    public Person (int age, String name) {
        this.age = age;
        this.name = name;
    }
}




/*
Input 1:
Pesho
20

Expected output 1:
No name 1
No name 20
Pesho 20


Input 2:
Gosho
18

Expected output 2:
No name 1
No name 18
Gosho 18



Input 3:
Stamat
43

Expected output 3:
No name 1
No name 14
Stamat 43


 */