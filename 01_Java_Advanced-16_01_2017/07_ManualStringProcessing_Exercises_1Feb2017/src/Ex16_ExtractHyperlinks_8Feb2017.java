import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;



public class Ex16_ExtractHyperlinks_8Feb2017 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder builder = new StringBuilder();
        String line = "";

        while (!"END".equals(line = reader.readLine())) {
            builder.append(line);
        }

        List<String> aTags = new ArrayList<>();
        String text = builder.toString();
        while (true) {
            int startIndex = text.indexOf("<a");
            int endIndex = text.indexOf(">", startIndex + 1);

            if(startIndex == -1 || endIndex == -1) {
                break;
            }

            aTags.add(text.substring(startIndex, endIndex));
            text = text.substring(endIndex + 1);
        }

        for (String aTag : aTags) {
            aTag = aTag.replaceAll("\\t", " ");
            int hrefIndex = aTag.indexOf(" href");
            if (hrefIndex == -1) {
                continue;
            }
            hrefIndex += 5;
            while (hrefIndex < aTag.length() && (
                    aTag.charAt(hrefIndex) == ' ' ||
                    aTag.charAt(hrefIndex) == '\t' ||
                    aTag.charAt(hrefIndex) == '\"' ||
                    aTag.charAt(hrefIndex) == '\'' ||
                    aTag.charAt(hrefIndex) == '=')) {
                hrefIndex++;
            }

            char delimiter = aTag.charAt(hrefIndex - 1);

            if(delimiter == ' ' || delimiter == '\t' ||
                    delimiter == '\'' || delimiter == '\"') {
                int nextDelimiter = aTag.indexOf(delimiter, hrefIndex + 1);
                if (nextDelimiter != -1) {
                    System.out.println(aTag.substring(hrefIndex, nextDelimiter));
                }
            } else {
                int spaceIndex = aTag.indexOf(' ', hrefIndex + 1);
                if (spaceIndex != -1) {
                    System.out.println(aTag.substring(hrefIndex, spaceIndex));
                } else {
                    System.out.println(aTag.substring(hrefIndex));
                }
            }
        }
    }
}


/*
Alternative solution with REGEX
package F_ManualStringProcessing.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P_ExtractHyperlinks16 {
    public static void main(String[] args) throws IOException {

        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder text = new StringBuilder();
        String pattern = "<a\\s+([^>]+\\s+)?href\\s*=\\s*('([^']*)'|\"([^\"]*)|([^\\s>]+))[^>]*>";
        Pattern p = Pattern.compile(pattern);

        while (true){
            String input = scan.readLine();
            if("END".equals(input)){
                break;
            }
            text.append(input);
        }
        Matcher m = p.matcher(text);
        while (m.find( )){
            for (int i = 5; i >= 1; i--) {
                if(m.group(i) != null){
                    System.out.println(m.group(i) );
                    break;
                }
            }
        }
    }
}
 */



/*
Input 1:
<a href="http://softuni.bg" class="new"></a>
END

Expected output 1:
http://softuni.bg


Input 2:
<p>This text has no links</p>
END

Expected output 2:
(no output)



Input 3:
<!DOCTYPE html>
<html>
<head>
<title>Hyperlinks</title>
<link href="theme.css" rel="stylesheet" />
</head>
<body>
<ul><li><a   href="/"  id="home">Home</a></li><li><a
class="selected" href=/courses>Courses</a>
</li><li><a href =
'/forum' >Forum</a></li><li><a class="href"
onclick="go()" href= "#">Forum</a></li>
<li><a id="js" href =
"javascript:alert('hi yo')" class="new">click</a></li>
<li><a id='nakov' href =
http://www.nakov.com class='new'>nak</a></li></ul>
<a href="#empty"></a>
<a id="href">href='fake'<img src='http://abv.bg/i.gif'
alt='abv'/></a><a href="#">&lt;a href='hello'&gt;</a>
<!-- This code is commented:
<a href="#commented">commentex hyperlink</a> -->
</body>
END


Expected output 3:
/
/courses
/forum
#
javascript:alert('hi yo')
http://www.nakov.com
#empty
#
#commented


 */
