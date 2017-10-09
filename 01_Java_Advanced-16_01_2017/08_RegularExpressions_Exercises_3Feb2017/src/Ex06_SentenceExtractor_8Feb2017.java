import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Ex06_SentenceExtractor_8Feb2017 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String keyword = reader.readLine();
        String text = reader.readLine();

        Pattern pattern = Pattern.compile("([^.!?]+\\b"+keyword+"\\b[^.!?]+[.!?])");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}


/*
Input 1:
is
This is my cat! And this is my dog. We happily live in Paris – the most beautiful city in the world! Isn’t it great? Well it is :)

Expected output 1:
This is my cat!
And this is my dog.


Input 2:
is
No keyword in this sentence.

Expected output 2:
(no output)


 */