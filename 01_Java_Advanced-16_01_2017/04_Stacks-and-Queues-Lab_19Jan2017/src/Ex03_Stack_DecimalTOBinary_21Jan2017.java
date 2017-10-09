import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayDeque;

public class Ex03_Stack_DecimalTOBinary_21Jan2017 {
    public static void main(String[] args){
        Locale.setDefault(Locale.ROOT);
        Scanner scanner = new Scanner(System.in);

        long decNumber = Long.parseLong(scanner.nextLine());

        ArrayDeque<Long> result = new ArrayDeque<Long>();

        if(decNumber == 0){
            System.out.println(0);
            return;
        }

        while (decNumber != 0) {
            result.push(decNumber % 2);
            decNumber /= 2;
        }

        while(!result.isEmpty()){
            System.out.print(result.pop());
        }
        System.out.println();
    }
}

//Input
//10
//5