import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex08_ExtracQuotations_3Feb2017 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("('|\")(.+?)\\1");


        String line = reader.readLine();
        Matcher matcher = pattern.matcher(line);

        while (matcher.find()) {
            System.out.println(matcher.group(2));
        }
    }
}

/*
Input 1:
<a href='/' id="home">Home</a><a class="selected"</a><a href = '/forum'>


Expected output 1:
/
home
selected
/forum



Input 2:
<a href='/' id='home">

Expected output 2:
/


Input 3:
Skip "nested 'quotes'"

Expected output 3:
nested 'quotes'


Input 4:
No quotes.

Expected output 4:
/
 */

