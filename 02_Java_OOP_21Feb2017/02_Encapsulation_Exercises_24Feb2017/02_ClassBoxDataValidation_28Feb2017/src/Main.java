import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Class boxClass = Box.class;
        Field[] fields = boxClass.getDeclaredFields();

        double length = Double.parseDouble(reader.readLine());
        double width = Double.parseDouble(reader.readLine());
        double height = Double.parseDouble(reader.readLine());

        try {
            Box box = new Box(length, width, height);
            System.out.println(box);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }

//        System.out.println(Arrays.asList(fields)
//        .stream()
//        .filter(f -> Modifier.isPrivate(f.getModifiers())).count());
    }
}

/*
Input 1:
2
3
4

Expected output 1:
Surface Area – 52.00
Lateral Surface Area – 40.00
Volume – 24.00


Input 2:
1.3
1
6

Expected output 2:
Surface Area - 30.20
Lateral Surface Area - 27.60
Volume - 7.80


Input 3:
2
-3
4

Expected output 3:
Width cannot be zero or negative.

 */
