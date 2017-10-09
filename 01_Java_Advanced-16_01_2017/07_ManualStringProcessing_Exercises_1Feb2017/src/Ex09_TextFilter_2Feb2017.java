import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex09_TextFilter_2Feb2017 {
    public static void main(String[] args) {
        try {
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(System.in));

            String[] banList = input.readLine().split(", ");
            StringBuilder text = new StringBuilder(input.readLine());

            int startIndex;
            for (String s : banList) {
                while (true) {
                    startIndex = text.indexOf(s);
                    if (startIndex != -1) {
                        int endIndex = startIndex + s.length();
                        text.delete(startIndex, endIndex);
                        for (int i = startIndex; i < endIndex; i++) {
                            text.insert(i, "*");
                        }
                    } else {
                        break;
                    }
                }
            }
            System.out.println(text);


        } catch (IOException ioex) {
            System.out.println(ioex.getMessage());
        }
    }
}

/*
Input:
Linux, Windows
It is not Linux, it is GNU/Linux. Linux is merely the kernel, while GNU adds the functionality. Therefore we owe it to them by calling the OS GNU/Linux! Sincerely, a Windows client


Expected output:
It is not *****, it is GNU/*****. ***** is merely the kernel, while GNU adds the functionality. Therefore we owe it to them by calling the OS GNU/*****! Sincerely, a ******* client

 */


//Alternative solution:
/*Scanner scanner = new Scanner(System.in);
    String[] bannedWords = scanner.nextLine().split(", ");
    String text = scanner.nextLine();
        for (String bannedWord : bannedWords) {
                text = text.replaceAll(bannedWord, new String(new char[bannedWord.length()]).replace('\0', '*'));
                }
                System.out.println(text); */