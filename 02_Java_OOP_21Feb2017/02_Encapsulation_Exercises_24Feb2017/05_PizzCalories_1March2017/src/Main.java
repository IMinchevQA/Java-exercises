import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static boolean isExceptionFound = false;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = "";


        while (!"END".equals(line = reader.readLine()) && !isExceptionFound){
            String[] inputTokens = line.trim().split("\\s+");

            switch (inputTokens[0].toLowerCase().trim()) {
                case "pizza":
                    executeCreatePizza(inputTokens, reader);
                    break;
                case "dough":
                    executeCreateDough(inputTokens);
                    break;
                case "topping":
                    executeCreateTopping(inputTokens);
            }
        }


    }

    private static void executeCreateTopping(String[] inputTokens) {
        try {
            Topping topping = new Topping(inputTokens[1], Double.parseDouble(inputTokens[2]));
            System.out.printf("%.2f", topping.CalculateToppingCalories());
            System.out.println();
        } catch (CE ce) {
            System.out.println(ce.getMessage());
            isExceptionFound = true;
        }

    }

    private static void executeCreateDough(String[] inputTokens) {
        try {
            Dough dough = new Dough(inputTokens[1], inputTokens[2], Double.parseDouble(inputTokens[3]));
            System.out.printf("%.2f", dough.CalculateDoughCalories());
            System.out.println();
        } catch (CE ce) {
            System.out.println(ce.getMessage());
            isExceptionFound = true;
        }
    }

    private static void executeCreatePizza(String[] inputTokens, BufferedReader reader) throws IOException {
        try {
            Pizza pizza = new Pizza(inputTokens[1].trim(), Integer.parseInt(inputTokens[2]));
            inputTokens = reader.readLine().trim().split("\\s+");
            Dough dough = new Dough(inputTokens[1], inputTokens[2], Double.parseDouble(inputTokens[3]));
            pizza.setDough(dough);

            for (int i = 0; i < pizza.getNumberOfTopping(); i++) {
                inputTokens = reader.readLine().trim().split("\\s+");
                Topping topping = new Topping(inputTokens[1], Double.parseDouble(inputTokens[2]));
                pizza.addTopping(topping);
            }
            System.out.println(pizza);

        } catch (CE ce) {
            System.out.println(ce.getMessage());
            isExceptionFound = true;
        }
    }
}

/*
Input:
Pizza Bulgarian 20
Dough Tip500 Balgarsko 100
Topping Sirene 50
Topping Cheese 50
Topping Krenvirsh 20
Topping Meat 10
END

Expected output:
Number of toppings should be in range [0..10].

 */
