import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Ex05_ExtractTags_3Feb2017 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("<.+?>");
        String line = reader.readLine();

        while (!"END".equals(line)) {
            Matcher matcher = pattern.matcher(line);

            while(matcher.find()) {
                System.out.println(matcher.group());
            }
            line = reader.readLine();
        }
    }
}

/*
Input 1:
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
</html>
END



Expected output 1:
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>
</title>
</head>
</html>



Input 2:
No tags.
END



Expected output 2:

 */

