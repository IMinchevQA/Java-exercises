package Ex03_CoffeMachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CoffeeMachine machine = new CoffeeMachine();

        String input;

        while (!"END".equals(input = reader.readLine())) {
            String[] lineToknes = input.split("\\s+");

            if (lineToknes.length == 1) {
                machine.insertCoin(lineToknes[0]);
            } else {
                machine.buyCoffee(lineToknes[0], lineToknes[1]);
            }
        }

        for (Coffee coffee : machine.coffeesSold()) {
            System.out.println(coffee);
        }
    }
}

/*
Input 1:
TEN
TWENTY
TWENTY
Small Espresso
END

Expected output 1:
"Small Espresso" sold


Input 2:
TEN
TWENTY
Small Espresso
TWENTY
Small Espresso
END

Expected output 2:
"Small Espresso" sold

 */