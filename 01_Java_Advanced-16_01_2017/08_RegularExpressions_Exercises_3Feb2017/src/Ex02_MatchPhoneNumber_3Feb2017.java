import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex02_MatchPhoneNumber_3Feb2017 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("\\+359( |-)2\\1\\d{3}\\1\\d{4}\\b");
        String line = reader.readLine();

        while (!"end".equals(line)) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                System.out.println(matcher.group());
            }

            line = reader.readLine();
        }
    }
}

/*
Input 1:
+359 2 222 2222
+3591345123
end

Expected output 1:
+359 2 222 2222



Input 2:
+359 2 234 5678
+359-2-234-5678
+359-2 234-5678
end



Expected output 2:
+359 2 234 5678
+359-2-234-5678




*/
