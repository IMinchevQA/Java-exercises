import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Ex04_GroupNumbers_19Jan2017 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner input = new Scanner(System.in);
        String[] numbers = input.nextLine().split(", ");
        int[] rowsSizes = new int[3];

        //Keeping information about rows next FREE FOR USING index.
        int[] rowsFreeIndices = {0, 0, 0};


        //Initializing each row size!!!
        for (String number : numbers){
            //Using of Math.abs to avoid error due to NEGATIVE remainder
            int remainder = Math.abs(Integer.parseInt(number) % 3);
            rowsSizes[remainder]++;
        }

        int[][] numbersByReminder = { new int[rowsSizes[0]], new int[rowsSizes[1]], new int[rowsSizes[2]] };

        for (String number: numbers){
            //Using of Math.abs to avoid error due to NEGATIVE remainder
            int remainder = Math.abs(Integer.parseInt(number) % 3);
            int index = rowsFreeIndices[remainder];
            numbersByReminder[remainder][index] = Integer.parseInt(number);
            rowsFreeIndices[remainder]++;
        }

        for (int[] row : numbersByReminder) {
            for (int number : row) {
                System.out.print(number + " ");
            }
            System.out.println();
        }

    }
}


//input = 1, 4, -113, 55, -3, 1, -2, 66, 557, -124, 2