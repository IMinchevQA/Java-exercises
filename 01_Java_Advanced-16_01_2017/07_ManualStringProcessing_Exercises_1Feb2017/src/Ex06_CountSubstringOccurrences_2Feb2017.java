import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex06_CountSubstringOccurrences_2Feb2017 {
    public static void main(String[] args) {
        try{
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(System.in));

            StringBuilder text = new StringBuilder(input.readLine().toLowerCase());
            String keyWord = input.readLine().toLowerCase();
            int cntOccurrences = 0;
            int startIndex;

            while (true) {
                startIndex = text.indexOf(keyWord);
                if (startIndex != -1) {
                    int endIndex = startIndex + 1;
                    text.delete(startIndex, endIndex);
                    cntOccurrences++;
                } else {
                    break;
                }
            }
            System.out.println(cntOccurrences);

        } catch (IOException ioex) {
            System.err.println(ioex.getMessage());
        }
    }
}

/*
Input 1:
Welcome to the Software University (SoftUni)! Welcome to programming. Programming is wellness for developers, said Maxwell.
wel

Expected output 1:
4


Input2:
aaaaaa
aa

Expexcted output 2:
5



Input3:
ababa caba
aba

Expected output 3
3


Input 4:
Welcome to SoftUni
Java

Expected output:
0


 */

