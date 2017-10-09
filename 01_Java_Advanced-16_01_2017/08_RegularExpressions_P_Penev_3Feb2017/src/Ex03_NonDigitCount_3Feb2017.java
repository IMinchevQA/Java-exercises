import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex03_NonDigitCount_3Feb2017 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("[\\D]");
        Matcher matcher = pattern.matcher(reader.readLine());
        int cnt = 0;
        while (matcher.find()) {
            cnt++;
        }
        System.out.printf("Non-digits: %s", cnt);
    }
}

/*
Input 1:
Abraham Lincoln


Expected output 1:
Non-digits: 15


Input 2:
In 1519 Leonardo da Vinci died at the age of 67.


Expected output 2:
Non-digits: 42


Input 3:
0


Expected output 3:
Non-digits: 0
 */
