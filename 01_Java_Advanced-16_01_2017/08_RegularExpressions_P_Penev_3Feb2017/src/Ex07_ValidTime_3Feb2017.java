import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex07_ValidTime_3Feb2017 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2}) (AM|PM)$");

        String line = reader.readLine();

        while (!"END".equals(line)) {
            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {
                int hour = Integer.valueOf(matcher.group(1));
                int minutes = Integer.valueOf(matcher.group(2));
                int seconds = Integer.valueOf(matcher.group(3));

                if (isValid(hour, minutes, seconds)){
                    System.out.println("valid");
                } else {
                    System.out.println("invalid");
                }

            } else {
                System.out.println("invalid");
            }
            line = reader.readLine();


        }

    }

    private static boolean isValid(int hour, int minutes, int seconds) {
        if (!(1 <= hour && hour <= 12)) {
            return false;
        }

        if (!(0 <= minutes && minutes <= 59)) {
            return false;
        }

        if (!(0 <= seconds && seconds <= 59)) {
            return false;
        }
        return true;
    }
}

/*
Input 1:
12:33:24 AM
33:12:11 PM
inv 23:52:34 AM
00:13:23     PM
9:3:12 АМ
END


Expected output 1:
valid
invalid
invalid
invalid
invalid




Input 2:
END

Expected output 2:


 */
