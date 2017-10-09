import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex04_ReplaceAtag_3Feb2017 {
    public static void main (String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder inputOnALine = new StringBuilder();

        while (!"END".equals(line = reader.readLine())) {
            inputOnALine.append(line)
                        .append("\r\n");
        }

        Pattern pattern = Pattern.compile("<a\\s+(href=[^>]+)>([^<]+)</a>");
        Matcher matcher = pattern.matcher(inputOnALine.toString());

        while (matcher.find()) {
            int startMatch = matcher.start();
            int endMatch = matcher.end();
            String replacement = createReplacement(matcher);
            inputOnALine.replace(startMatch, endMatch, replacement);
            //Important, the matcher should be rei
            matcher = pattern.matcher(inputOnALine.toString().trim());
        }
        System.out.println(inputOnALine.toString());
    }


    public static String createReplacement(Matcher matcher) {
        String replacementString = "[URL " + matcher.group(1) + "]" + matcher.group(2) + "[/URL]";

        return replacementString;
    }
}

/*
Input 1:
<ul> <li> <a href="http://softuni.bg">SoftUni</a>
 </li> </ul>
END


Output 1:
<ul> <li>
  [URL href=http://softuni.bg]SoftUni[/URL]
 </li>
</ul>




Input2:
<a href="/">
Link</a>
END

Output 2:
[URL href="/"]
Link[/URL]

 */






//        while(input != "end")
//        {
//            sb.Append(input);
//            sb.Replace(" ", ""); // removing white spaces
//            sb.Replace("\t", ""); // removing white spaces
//            input = Console.ReadLine();
//        }
//
//        string fromSB = sb.ToString();
//        input = Regex.Replace(fromSB, pattern, m => "[URL " + m.Groups[1].Value + "]" + m.Groups[2].Value + "[/URL]");
//
//        Console.WriteLine(input);

