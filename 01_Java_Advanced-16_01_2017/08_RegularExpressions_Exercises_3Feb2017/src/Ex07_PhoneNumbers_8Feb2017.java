import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex07_PhoneNumbers_8Feb2017 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder inputText = new StringBuilder();

        Pattern pattern = Pattern.compile("([A-Z][a-zA-Z]*)[^a-zA-Z\\+]*?(?=\\+|[0-9]{2})([0-9\\+]{0,1}[0-9][0-9\\/(). -]*[0-9])");

        String line = "";
        while (!"END".equals(line = reader.readLine())) {
            inputText.append(line);
        }

        String text = inputText.toString();
        Matcher matcher = pattern.matcher(text);
        LinkedHashMap<String, String> phoneBook = new LinkedHashMap<>();

        while (matcher.find()) {
            String name = matcher.group(1);
            String phoneNumber = matcher.group(2);
            phoneNumber = phoneNumber.replace("(", "");
            phoneNumber = phoneNumber.replace(")", "");
            phoneNumber = phoneNumber.replace("/", "");
            phoneNumber = phoneNumber.replace(".", "");
            phoneNumber = phoneNumber.replace("-", "");
            phoneNumber = phoneNumber.replace(" ", "");
            phoneBook.put(name, phoneNumber);
        }


        int cntPrinted = 0;
        if (!phoneBook.isEmpty()) {
            System.out.print("<ol>");
            for (String s : phoneBook.keySet()) {
                if (cntPrinted < phoneBook.size()-1) {
                    System.out.printf("<li><b>%1$s:</b> %2$s</li>", s, phoneBook.get(s));
                    cntPrinted++;
                } else {
                    System.out.printf("<li><b>%1$s:</b> %2$s</li></ol>", s, phoneBook.get(s));
                }
            }
        } else {
            System.out.println("<p>No matches!</p>");
        }
    }
}


/*
Input 1:
Angel$(*^#029661234!@#Pesho ,.' +3592/9653241;'“:{},.
Ivan 0888 123 456 John-=_555.123.4567	Stoian!@#$#@	Gosho )=_*	Steven #$(*&+1-(800)-555-2468
END


Expected output 1:
<ol><li><b>Angel:</b> 029661234</li>
<li><b>Pesho:</b> +35929653241</li>
<li><b>Ivan:</b> 0888123456</li>
<li><b>John:</b> 5551234567</li>
<li><b>Steven:</b> +18005552468</li></ol>


Input 2:
There are no phone numbers here!!!
END


Expected output 2:
<p>No matches!</p>

*/