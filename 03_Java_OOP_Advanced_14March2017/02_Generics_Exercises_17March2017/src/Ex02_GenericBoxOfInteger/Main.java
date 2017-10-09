package Ex02_GenericBoxOfInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
        private static Box<?> box;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            try {
                Box<Integer> newBox = new BoxImpl<>(Integer.parseInt(line));
                box = newBox;
            } catch (NumberFormatException nfe) {
                try {
                    Box<Double> newBox = new BoxImpl<>(Double.parseDouble(line));
                    box = newBox;
                } catch (NumberFormatException nfe2) {
                    Box<String> newBox = new BoxImpl<>(line);
                    box = newBox;
                }
            }
            System.out.println(box);
        }
    }
}


/*
Input 1:
2
life in a box
box in a life

Expected output 1:
java.lang.String: life in a box
java.lang.String: box in a life


Input 2:
3
7
123
42

Expected output 2:
2
life in a box
box in a life


 */