import java.util.ArrayList;
import java.util.Scanner;
import java.util.Locale;

public class Ex10_FirstOddOrEvenElements_18Jan2017 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner input = new Scanner(System.in);
        String[] numbStr = (input.nextLine()).split("\\s");
        //Missing the 'Get' word!!!
        input.next();

        int countNumbers = input.nextInt();
        String oddOrEven = input.next();
        ArrayList<Integer> resultNums = new ArrayList<Integer>();

        for (int i = 0; i < numbStr.length; i++) {

            switch (oddOrEven.toLowerCase()) {
                case "odd":
                    if(Integer.valueOf(numbStr[i]) % 2 != 0
                            &&resultNums.size() < countNumbers){
                        resultNums.add(Integer.valueOf(numbStr[i]));
                    }
                    break;
                case "even":
                    if(Integer.valueOf(numbStr[i]) % 2 == 0
                            &&resultNums.size() < countNumbers){
                        resultNums.add(Integer.valueOf(numbStr[i]));
                    }
                    break;
            }
        }

        for(int number : resultNums){
            System.out.print(number + " ");
        }
    }
}