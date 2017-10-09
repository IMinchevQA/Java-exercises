import java.util.HashMap;
import java.util.Scanner;

public class Ex04_Special_Words_1Feb2017 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] specialWords = scanner.nextLine().split("\\s+");
        String[] text = scanner.nextLine().split("\\s+");
        HashMap<String, Integer> result = new HashMap<String, Integer>();

        for (String specialWord : specialWords) {
            for (String str : text) {
                if(specialWord.compareToIgnoreCase(str) == 0) {
                    if (result.containsKey(specialWord)) {
                        result.put(specialWord, result.get(specialWord) + 1);
                    } else {
                        result.put(specialWord, 1);
                    }
                }
            }
        }

        for (String s : result.keySet()) {
            System.out.println(s + " - " + result.get(s));
        }
    }
}


/*
Input1:
OpenJDK SE GNU GPL
OpenJDK is another notable Java SE implementation that is licensed under the GNU GPL

Expected output
SE - 1
GPL - 1
OpenJDK - 1
GNU - 1

Input2:
OpenJDK SE GNU OOP
OpenJDK is another notable Java SE implementation that is licensed under the GNU GPL

Expected output:
OOP - 0
SE - 1
OpenJDK - 1
GNU - 1



 */
