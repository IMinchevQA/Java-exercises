package Ex04_GenericSwapMethodInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {
    private static Box<?> box = new BoxImpl<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String line = reader.readLine();

            try {
                Box<Integer> newBox = new BoxImpl<>(Integer.parseInt(line));
                box.addBox(newBox);

            } catch (NumberFormatException nfe) {
                Box<String> newBox = new BoxImpl<>(line);
                box.addBox(newBox);
            }
        }

        box.swap(reader.readLine().trim().split("\\s+"));

        for (Box singleBox : box.getListOfBoxes()) {
            System.out.println(singleBox);
        }


    }
}

/*
Input 1:
3
Pesho
Gosho
Swap me with Pesho
0 2

Expected output 1:
java.lang.String: Swap me with Pesho
java.lang.String: Gosho
java.lang.String: Pesho



Input 2:
3
7
123
42
0 2

Expected output 2:
java.lang.Integer: 42
java.lang.Integer: 123
java.lang.Integer: 7


 */
