import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex02_StringLength_2Feb2017 {
    public static void main(String[] args) {
        try{
            String input = new BufferedReader(
                    new InputStreamReader(System.in))
                    .readLine();

            if (input.length() < 20) {
                StringBuilder resultStr = new StringBuilder(input);
                while (resultStr.length() < 20) {
                    resultStr.append("*");
                }
                System.out.println(resultStr);
                return;
            }

            System.out.println(input.substring(0, 20));

        } catch (IOException ioex) {
            System.err.println("Cannot read n.");
        }
    }
}

/*
Input 1:
Welcome to SoftUni!

Expected output 1:
Welcome to SoftUni!*


Input 2:
a regular expression (abbreviated regex or regexp and sometimes called a rational expression) is a sequence of characters that forms a search pattern

Expected output 2:
a regular expression


Input 3:
C#

Expected output 3:
C#******************

 */
