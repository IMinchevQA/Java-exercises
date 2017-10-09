import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Ex03_CountUpperCaseWords_10Feb2017 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> textAsList = Arrays.asList(reader.readLine().split(" "));

        Predicate<String> checkerUpperCase = s -> s.charAt(0) == s.toUpperCase().charAt(0);

        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < textAsList.size(); i++) {
            if (checkerUpperCase.test(textAsList.get(i))) {
                result.add(textAsList.get(i));
            }
        }

        System.out.println(result.size());

        for (String s : result) {
            System.out.println(s);
        }
    }
}


/*
Input 1:
The following example shows how to use Predicate

Expected output 1:
2
The
Predicate



Input 2:
Write a program that reads one line of text from console. Print count of words that start with Uppercase, after that print all those words in the same order like you find them in text.

Expected output 2:
3
Write
Print
Uppercase,



*/