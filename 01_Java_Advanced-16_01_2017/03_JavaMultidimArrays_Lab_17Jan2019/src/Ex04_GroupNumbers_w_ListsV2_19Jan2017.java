import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Ex04_GroupNumbers_w_ListsV2_19Jan2017 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        Scanner input = new Scanner(System.in);
        String[] numbers = input.nextLine().split(", ");

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
        matrix.add(0, new ArrayList<Integer>());
        matrix.add(1, new ArrayList<Integer>());
        matrix.add(2, new ArrayList<Integer>());

        for(String number: numbers){
            int currentNum = Integer.parseInt(number);
            matrix.get(Math.abs(currentNum % 3)).add(currentNum);
        }

        for(ArrayList<Integer> number : matrix){
            for (Integer integer : number) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}

//input 1, 4, -113, 55, -3, 1, -2, 66, 557, -124, 2