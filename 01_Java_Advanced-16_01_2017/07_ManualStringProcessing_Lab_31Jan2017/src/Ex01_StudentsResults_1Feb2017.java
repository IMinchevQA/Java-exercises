import java.util.*;
import java.util.Locale;

public class Ex01_StudentsResults_1Feb2017 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        TreeMap<String, List<Double>> result = new TreeMap<>();
        for (int i = 0; i < number; i++) {
            String[] input = scanner.nextLine().split(" - ");
            String[] examResultsStr = input[1].split(", ");

            List<Double> examResults = new ArrayList<>();
            double sum = 0;
            for (String resultStr : examResultsStr) {
                double currentResult = Double.parseDouble(resultStr);
                examResults.add(currentResult);
                sum += currentResult;
            }

            //Adding the average result in the List - examResults
            examResults.add(sum / 3);


            result.put(input[0], examResults);
        }

        if (number != 0) {
            System.out.println(String.format("%1$-10s|%2$7s|%3$7s|%4$7s|%5$7s|", "Name", "JAdv", "JavaOOP", "AdvOOP", "Average").replace('.', ','));
            for (String name : result.keySet()) {
                List<Double> examResults = result.get(name);
                Iterator<Double> it = examResults.iterator();
                System.out.println(String.format("%1$-10s|%2$7.2f|%3$7.2f|%4$7.2f|%5$7.4f|", name, it.next(), it.next(), it.next(), it.next()).replace(".", ","));
            }
        }
    }
}


/*
Input:
1
Gosho - 3.33333, 4.4444, 5.555

Expected output1:
Name      |   JAdv|JavaOOP| AdvOOP|Average|
Gosho     |   3,33|   4,44|   5,56| 4,4442|


Input2:
2
Mara - 5, 4, 3
Gosho - 3, 4, 5

Expected output2:
Name      |   JAdv|JavaOOP| AdvOOP|Average|
Gosho     |   3,00|   4,00|   5,00| 4,0000|
Mara      |   5,00|   4,00|   3,00| 4,0000|


 */