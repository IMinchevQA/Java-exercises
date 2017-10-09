import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex12_CharacterMultiplier_2Feb2017 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        String firstWord = input[0];
        String secondWord = input[1];

        long result = 0;

        int length = Math.min(firstWord.length(), secondWord.length());

        for (int i = 0; i < length; i++) {
            result += firstWord.charAt(i) * secondWord.charAt(i);
        }

        while (length < firstWord.length()) {
            result += firstWord.charAt(length);
            length++;
        }

        while (length < secondWord.length()) {
            result += secondWord.charAt(length);
            length++;
        }
        System.out.println(result);
    }
}

/*
Input 1:
Gosho Pesho

Expected output 1:
53253



Input2:
123 522

Expexcted output 2:
7647



Input3:
a aaaa

Expected output 3
9700

 */
