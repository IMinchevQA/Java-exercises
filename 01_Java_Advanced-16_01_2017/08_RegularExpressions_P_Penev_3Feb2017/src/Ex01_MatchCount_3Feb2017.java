import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex01_MatchCount_3Feb2017 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile(reader.readLine());
        Matcher matcher = pattern.matcher(reader.readLine());

        int cnt = 0;
        while (matcher.find()) {
            cnt++;
        }
        System.out.println(cnt);
    }
}


/*
Input 1:
regex
A regular expression, regex or regexp (sometimes called a rational expression) is, in theoretical computer science and formal language theory, a sequence of characters that define a search pattern.


Expected output 1:
2


Input 2:
regex
A regular expression, regex or regexp (sometimes called a rational expression) is, in theoretical computer science and formal language theory, a sequence of characters that define a search pattern.


Expected output 2:
6

 */