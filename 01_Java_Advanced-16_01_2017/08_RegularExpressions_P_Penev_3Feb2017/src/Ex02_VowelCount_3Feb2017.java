import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex02_VowelCount_3Feb2017 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("[aeiouy]");
        Matcher matcher = pattern.matcher(reader.readLine().toLowerCase());
        int cnt = 0;
        while (matcher.find()) {
            cnt++;
        }
        System.out.printf("Vowels: %s", cnt);
    }
}

/*
Input 1:
Abraham Lincoln


Expected output 1:
Vowels: 5


Input 2:
In 1519 Leonardo da Vinci died at the age of 67.


Expected output 2:
Vowels: 15


Input 3:
n vwls.


Expected output 1:
Vowels: 0
 */
