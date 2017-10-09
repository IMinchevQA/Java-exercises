package Ex02_Collection;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


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
                case "printall":
                    System.out.println(listyIterator.printAll());
                    break;
            }
        }
    }
}

/*
Input 1:
Create 1 2 3 4 5
Move
PrintAll
END


Expected output 1:
true
1 2 3 4 5


Input 2:
Create Stefcho Goshky Peshu
PrintAll
Move
Move
Print
HasNext
END


Expected output 2:
Stefcho Goshky Peshu
true
true
Peshu
false



 */
