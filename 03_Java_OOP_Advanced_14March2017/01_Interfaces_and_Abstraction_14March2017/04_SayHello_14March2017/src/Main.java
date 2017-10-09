import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();

        persons.add(new Bulgarian("Pesho"));
        persons.add(new European("Peter"));
        persons.add(new Chinese("Pin-Pjun"));

        persons.stream().forEach(p -> print(p));
    }

    private static void print(Person person) {
        System.out.println(person.sayHello());
    }
}
