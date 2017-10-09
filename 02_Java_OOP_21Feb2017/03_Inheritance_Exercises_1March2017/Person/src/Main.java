import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        int age = Integer.parseInt(reader.readLine());

        try {
            Child child = new Child(name, age);
            System.out.println(child.toString());
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            return;
        }
    }
}

/*
Input 1:
Pesho
13

Expected output 1:
Name: Pesho, Age: 13


Input 2:
Gog
17

Expected output 2:
Child's age must be lesser than 15!

 */
