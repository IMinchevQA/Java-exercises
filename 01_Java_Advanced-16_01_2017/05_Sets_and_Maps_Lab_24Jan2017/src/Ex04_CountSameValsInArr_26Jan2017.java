import java.util.*;

public class Ex04_CountSameValsInArr_26Jan2017 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split("\\s+");
        
        HashMap<String, Integer> results = new HashMap<String, Integer>();

        for (int i = 0; i < input.length; i++) {

            if (!results.containsKey(input[i])) {
                results.put(input[i], 1);
            } else {
                results.put(input[i], results.get(input[i]) + 1);
            }
        }

        for (String key : results.keySet()) {
            System.out.println(key + " - " + results.get(key) + " times");
        }
    }
}


//input -
// -2.5 4 3 -2.5 -5.5 4 3 3 -2.5 3
//Expected output
//3 - 4 times
//4 - 2 times
//-2.5 - 3 times
//-5.5 - 1 times

//input -
// 2 4 4 5 5 2 3 3 4 4 3 3 4 3 5 3 2 5 4 3
//Expected output
//2 - 3 times
//3 - 7 times
//4 - 6 times
//5 - 4 times

