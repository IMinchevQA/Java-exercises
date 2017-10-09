package Ex01_DefineAnInterfacePerson_15March2017;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        Class[] citizenInterfaces = Citizen.class.getInterfaces();

        if(Arrays.asList(citizenInterfaces).contains(Person.class)) {
            Method[] methods = Person.class.getDeclaredMethods();
            System.out.println(methods.length);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String name = reader.readLine();
            int age = Integer.parseInt(reader.readLine());
            Person person = new Citizen(name, age);
            System.out.println(person.getName());
            System.out.println(person.getAge());
        }
    }
}


/*
Input 1:
Pesho
25

Expected output 1:
2
Pesho
25


 */
