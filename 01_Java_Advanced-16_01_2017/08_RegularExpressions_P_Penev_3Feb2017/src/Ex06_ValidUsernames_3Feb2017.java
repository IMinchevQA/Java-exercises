import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Ex06_ValidUsernames_3Feb2017 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("^[\\w-]{3,16}$");
        String line = reader.readLine();

        while (!"END".equals(line)) {
            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {
                System.out.println("valid");
                line = reader.readLine();
                continue;
            }
            System.out.println("invalid");
            line = reader.readLine();
        }
    }
}

/*
Input 1:
sh
too_long_username
!lleg@l ch@rs
jeff_butt
END

Expected output 1:
invalid
invalid
invalid
valid



Input 2:
END

Expected output 2:


 */
