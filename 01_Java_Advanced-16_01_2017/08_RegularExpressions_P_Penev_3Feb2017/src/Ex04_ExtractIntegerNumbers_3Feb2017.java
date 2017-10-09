import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex04_ExtractIntegerNumbers_3Feb2017 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(reader.readLine());

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}

/*
Input 1:
In 1519 Leonardo da Vinci died at the age of 67.


Expected output 1:
1519
67


Input 2:
Decimals: 7.22, 3.14. Negative -25.


Expected output 2:
7
22
3
14
25



Input 3:
No integers.


Expected output 3:
 */
