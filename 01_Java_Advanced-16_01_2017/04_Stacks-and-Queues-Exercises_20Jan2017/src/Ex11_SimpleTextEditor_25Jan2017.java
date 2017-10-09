import java.util.*;

public class Ex11_SimpleTextEditor_25Jan2017 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Deque<String> prevoiusCondition = new ArrayDeque<>();
        prevoiusCondition.push("");

        for (int i = 0; i < n; i++) {
            String[] commandLine = sc.nextLine().split("\\s+");
            switch(commandLine[0]){
                case "1":
                    prevoiusCondition.push((prevoiusCondition.peek() + commandLine[1]));
                    break;
                case "2":
                    String str = prevoiusCondition.peek();
                    int numberEraseCharacters = Integer.parseInt(commandLine[1]);
                    for (int  iErase = 0;  iErase < numberEraseCharacters; iErase++) {
                        String stringLeft = str.substring(0, str.length() - 1);
                        str = stringLeft;
                    }
                    prevoiusCondition.push(str);
                    break;
                case "3":
                    int charIndex = Integer.parseInt(commandLine[1]) - 1;
                    System.out.println(prevoiusCondition.peek().charAt(charIndex));
                    break;
                case "4":
                    prevoiusCondition.pop();
                    break;
            }
        }
    }
}

//Input - any integer number btw. 1 and 105