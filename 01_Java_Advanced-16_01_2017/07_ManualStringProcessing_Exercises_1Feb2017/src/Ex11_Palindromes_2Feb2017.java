import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Ex11_Palindromes_2Feb2017 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input[] = reader.readLine().split("[, .!?]+");
        TreeSet<String> palindromes = new TreeSet<>();

        for (String word : input) {
            if (word.equals(new StringBuilder(word).reverse().toString())) {
                palindromes.add(word);
            }
        }
        System.out.println(palindromes);
    }
}


/*

Input 1:
Hi,exe? ABBA! Hog fully a string. Bob


Expected output 1:
[a, ABBA, exe]


Input2:
aibohphobia is fear of palindromes ahahaha

Expexcted output 2:
[ahahaha, aibohphobia]



Input3:
aSantAAtnaSa is a rare sight

Expected output 3
[a, aSantAAtnaSa]

*/
