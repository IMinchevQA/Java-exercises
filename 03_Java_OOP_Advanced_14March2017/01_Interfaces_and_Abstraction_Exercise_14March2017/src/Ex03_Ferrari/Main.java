package Ex03_Ferrari;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.instrument.IllegalClassFormatException;

public class Main {
    public static void main(String[] args) throws IllegalClassFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String driverName = reader.readLine();

        Car ferrari = new Ferrari(driverName);
        System.out.printf("%s/%s/%s/%s", ferrari.getModel(), ferrari.brakes(), ferrari.gasPedal(), ferrari.getName());
        System.out.println();

        String ferrariName = Ferrari.class.getSimpleName();
        String carInterface = Car.class.getSimpleName();
        boolean isCreated = Car.class.isInterface();
        if (!isCreated) {
            throw new IllegalClassFormatException("No interface created!");
        }
    }
}


/*
Input 1:
Bat Giorgi

Expected output 1:
488-Spider/Brakes!/Zadu6avam sA!/Bat Giorgi
 */