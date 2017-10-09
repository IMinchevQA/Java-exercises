package Ex03_StackIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static StackIterator<Integer> customStack = new StackIterator<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        executeReadInputAndPerformCommands(reader);

        for (Integer element : customStack) {
            System.out.println(element);
        }

        for (Integer element : customStack) {
            System.out.println(element);
        }
    }

    private static void executeReadInputAndPerformCommands(BufferedReader reader) throws IOException {
        String line ="";
        String command;

        while(!"END".equals(line = reader.readLine())) {
            String[] lineTokens = line.split("[ ,]+");
            command = lineTokens[0];
            switch(command.toLowerCase()) {
                case "push":
                    for (int i = 1; i < lineTokens.length; i++) {
                        customStack.push(Integer.parseInt(lineTokens[i]));
                    }
                    break;
                case "pop":
                    try {
                        customStack.pop();
                    } catch (IndexOutOfBoundsException iobe) {
                        System.out.println("No elements");
                    }
                    break;
            }
        }
    }
}

/*
Input 1:
Push 1, 2, 3, 4
Pop
Push 1
END



Expected output 1:
1
3
2
1
1
3
2
1



Input 2:
Push 1, 2, 3, 4
Pop
Pop
Pop
Pop
Pop
END



Expected output 2:
No elements



 */
