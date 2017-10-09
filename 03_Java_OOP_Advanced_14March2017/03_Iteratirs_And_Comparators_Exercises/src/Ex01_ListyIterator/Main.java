package Ex01_ListyIterator;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static ListyIterator listyIterator;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        executeReadInputAndPerformCommands(reader);
    }

    private static void executeReadInputAndPerformCommands(BufferedReader reader) throws IOException {
        String line = "";


        String[] lineTokens;

        while (!"END".equals(line = reader.readLine())) {
            lineTokens = line.trim().split("\\s+");
            String command = lineTokens[0];

            switch (command.toLowerCase()) {
                case "create":
                    String[] createElements = new String[lineTokens.length - 1];
                    for (int i = 1; i < lineTokens.length; i++) {
                        createElements[i - 1] = lineTokens[i];
                    }
                    listyIterator = new ListyIterator<>(createElements);
                    break;
                case "hasnext":
                    System.out.println(listyIterator.iterator().hasNext());
                    break;
                case "move":
                    System.out.println(listyIterator.move());

                    break;
                case "print":
                    try {
                        System.out.println(listyIterator.iterator());
                    } catch (ArrayIndexOutOfBoundsException aiobe) {
                        System.out.println("Invalid Operation!");
                    }
                    break;
            }
        }
    }
}

/*
Input 1:
Create Stefcho Goshky
HasNext
Print
Move
Print
END

Expected output 1:
true
Stefcho
Goshky

Input 2:
Create 1 2 3
HasNext
Move
HasNext
HasNext
Move
HasNext
END

Expected output 2:
true
true
true
true
true
false


 */
