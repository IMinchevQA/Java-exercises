import java.util.ArrayDeque;
import java.util.Locale;
import java.util.Scanner;

public class Ex01_Stack_ReverseString_21Jan2017 {
    public static void main(String[] args){
        Locale.setDefault(Locale.ROOT);
        Scanner scanner = new Scanner(System.in);

        String inputString = scanner.nextLine();
        ArrayDeque<Character> reversed = new ArrayDeque<Character>();

        for (Character ch : inputString.toCharArray()) {
            reversed.push(ch);
        }

        while(!reversed.isEmpty()){
            System.out.print(reversed.pop());
        }
    }
}


//Input
//Learning Java
//Stacks and Queues