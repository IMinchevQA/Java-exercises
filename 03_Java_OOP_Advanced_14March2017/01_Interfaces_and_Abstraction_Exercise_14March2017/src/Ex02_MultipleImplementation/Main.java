package Ex02_MultipleImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        Class[] citizenInterfaces = Ex02_MultipleImplementation.Citizen.class.getInterfaces();

        if(Arrays.asList(citizenInterfaces).contains(Birthable.class)
                && Arrays.asList(citizenInterfaces).contains(Identifiable.class)) {
            Method[] methods = Birthable.class.getDeclaredMethods();
            System.out.println(methods.length);
            System.out.println(methods[0].getReturnType().getSimpleName());
            methods = Identifiable.class.getMethods();
            System.out.println(methods.length);
            System.out.println(methods[0].getReturnType().getSimpleName());
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String name = reader.readLine();
            int age = Integer.parseInt(reader.readLine());
            String id = reader.readLine();
            String birthdate = reader.readLine();
            Identifiable identifiable = new Ex02_MultipleImplementation.Citizen(name, age, id, birthdate);
            Birthable birthable = new Ex02_MultipleImplementation.Citizen(name, age, id, birthdate);
        }
    }
}

/*
Input 1:
Pesho
25
9105152287
15/05/1991

Expected output 1:
1
String
1
String

 */
