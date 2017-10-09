import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex01_ReverseAString_2Feb2017 {
    public static void main(String[] args) {

        try{
            String input = new BufferedReader(
                    new InputStreamReader(System.in))
                    .readLine();
            System.out.println(new StringBuilder(input).reverse());

        } catch (IOException ioex) {
            System.err.println("Cannot read n.");
        }
    }
}

/*
Input 1:
 sample

 Expected output 1:
 elpmas

 Input 2:
 24tvcoi92

 Expected output 2:
 29iocvt42
 */
