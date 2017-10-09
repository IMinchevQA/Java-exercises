import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Ex10_UnicodeChars_2Feb2017 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        for (char c : input.toCharArray()) {
            System.out.print(String.format("\\u%04x", (int)c));
        }
    }
}

/*

Input 1:
Hi!


Expected output 1:
\u0048\u0069\u0021


Input2:
What?!?

Expexcted output 2:
\0057\0068\0061\0074\003f\0021\003f



Input3:
SoftUni

Expected output 3
\0053\006f\0066\0074\0055\006e\0069

*/
