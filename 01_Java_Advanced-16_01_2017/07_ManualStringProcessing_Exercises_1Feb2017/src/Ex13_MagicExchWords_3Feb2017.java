import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Ex13_MagicExchWords_3Feb2017 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");

        String firstWord = input[0];
        String secondWord = input[1];

        HashSet<Character> firstWordChars = new HashSet<>();
        HashSet<Character> secondWordChars = new HashSet<>();

        for (Character ch : firstWord.toCharArray()) {
            firstWordChars.add(ch);
        }

        for (Character ch : secondWord.toCharArray()) {
            secondWordChars.add(ch);
        }

        if (firstWordChars.size() == secondWordChars.size()) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}

/*
Input 1:
gosho hapka

Expected output 1:
true



Input2:
aabbaa ddeedd

Expexcted output 2:
true



Input3:
foo bar

Expected output 3:
false



Input4:
Clint Eastwood

Expected output 4:
false



 */
