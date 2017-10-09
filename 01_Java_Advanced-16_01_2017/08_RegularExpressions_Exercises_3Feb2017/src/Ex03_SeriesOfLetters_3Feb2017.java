import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Ex03_SeriesOfLetters_3Feb2017 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Pattern pattern = Pattern.compile("([A-Za-z])\\1+");
        Matcher matcher = pattern.matcher(input);

        String replaced = "";
        while (matcher.find()) {

            replaced = matcher.replaceAll("$1");
        }
        System.out.println(replaced);
    }
}

/*
Input 1:
aaaaabbbbbcdddeeeedssaa

Expected output 1:
abcdedsa

Input 2:
Haaaveee a niceeee Daay!

Expected output 2:
Have a nice Day!



*/


//Points 80/100
/*public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("[A-Za-z]");
        Matcher matcher = pattern.matcher(reader.readLine());
        List<String> letters = new ArrayList<>();

        int cnt = 0;
        while (matcher.find()) {
            if (cnt > 0 && !matcher.group().equalsIgnoreCase(letters.get(cnt - 1))) {
                letters.add(matcher.group());
                cnt++;
            } else if (cnt == 0) {
                letters.add(matcher.group());
                cnt++;
            }
        }

        for (String letter : letters) {
            System.out.print(letter);
        }
    }*/