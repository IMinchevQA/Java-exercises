import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Ex08_SumOfAllValues_8Feb2017 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String keyString = reader.readLine();

        Pattern keyPattern = Pattern.compile("^(?<startKey>[a-zA-Z_]+)(?=[0-9])(?:.*)\\d(?<endKey>[a-zA-Z_]+)$");
        Matcher matcher = keyPattern.matcher(keyString);

        String startKey = "";
        String endKey = "";
        if (matcher.find()) {
            startKey = matcher.group("startKey");
            endKey = matcher.group("endKey");
        }

        String inputText = reader.readLine();

        if ("".equals(startKey) || "".equals(endKey)) {
            System.out.println("<p>A key is missing</p>");
            return;
        }

        Pattern numbersPattern = Pattern.compile(Pattern.quote(startKey) + "(?<number>-?\\d*(?:\\.?)\\d+)" + Pattern.quote(endKey));
        Matcher numberMatcher = numbersPattern.matcher(inputText);

        BigDecimal number = BigDecimal.ZERO;

        while (numberMatcher.find()) {
            String value = numberMatcher.group("number");
            number = number.add(new BigDecimal(value));
        }

        if (!number.equals(BigDecimal.ZERO)) {
            DecimalFormat format = new DecimalFormat("#.##");
            System.out.println("<p>The total value is: <em>" + format.format(number) + "</em></p>");
        } else {
            System.out.println("<p>The total value is: <em>nothing</em></p>");
        }
    }
}

/*
Input 1:
startKEY12adghfgh243212gadghfgs43endKEY
asdjykulgfjddfsffdstartKEY12endKEYqwfrhtyu67543rewghy3tefdgdstartKEY123.45endKEYwret34yrestartKEY2.6endKEY213434ytuhrgerweasfdstartKEYendKEYstartKEYasfdgeendKEY



Expected output 1:
<p>The total value is: <em>138.05</em></p>



Input 2:
startKEY12a

asdjykulgfjddfsffdstartKEY12endKEYqwfrhtyu67543rewghy3tefdgdstartKEY123.45endKEYwret34yrestartKEY2.6endKEY213434ytuhrgerweasfd
startKEYendKEYstartKEYasfdgeendKEY


Expected output 2:
<p>The total value is: <em>nothing</em></p>




Input 3:
startKEY12

asdjykulgfjddfsffdstartKEY12endKEYqwfrhtyu67543rewghy3tefdgd


Expected output 3:
<p>A key is missing</p>s

*/
