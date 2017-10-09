import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Class chickenClass = Chicken.class;
        Field[] fields = chickenClass.getDeclaredFields();
        String name = reader.readLine();
        int age = Integer.parseInt(reader.readLine());

        try {
            Chicken chickenToPrint = new Chicken(name, age);
            System.out.println(chickenToPrint);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}

/*
Input 1:
Mara
10

Expected output 1:
Chicken Mara (age 10) can produce 1 eggs per day.



Input 2:
Mara
17


Expected output 2:
Age should be between 0 and 15.
 */