import java.util.Scanner;
public class Ex03_ParseTags_1Feb2017 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String upcaseOpen = "<upcase>";
        String upcaseClose = "</upcase>";

        while (input.contains(upcaseOpen)) {
            int startIndex = input.indexOf(upcaseOpen);
            int endIndex = input.indexOf(upcaseClose);

            String remainder = input.substring(startIndex + upcaseOpen.length(), endIndex);
            input = input.replace((upcaseOpen + remainder + upcaseClose), remainder.toUpperCase());
        }
        System.out.println(input);
    }
}

/*
Input1:
We are living in a <upcase>yellow submarine</upcase>. We don't have <upcase>anything</upcase> else.

Expected output:
We are living in a YELLOW SUBMARINE. We don't have ANYTHING else.

Input2:
<upcase>StringBuilder</upcase> is <upcase>awesome</upcase>

Expected output:
STRINGBUILDER is AWESOME
 */
