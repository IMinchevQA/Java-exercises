import java.util.ArrayList;
import java.util.Scanner;

public class Extra_Ex05_ProblemTimest_2Feb2017 {
    private static StringBuilder sb = new StringBuilder();
    private static String concatStr = "";
    private static String plusStr = "";
    public static void main(String[] args) {

        String input = "Concatenate this strings with all three types";
        String[] str = input.split("\\s+");

        ArrayList<ArrayList<Long>> results = new ArrayList<>();
        results.add(new ArrayList<Long>());
        results.add(new ArrayList<Long>());
        results.add(new ArrayList<Long>());
        for (int i = 0; i < 1000; i++) {
            long startTime = System.nanoTime();
            for (String s : str) {
                plus(s);
            }
            long endTime = System.nanoTime();
            results.get(0).add(endTime - startTime);

            startTime = System.nanoTime();
            for (String s : str) {
                concat(s);
            }
            endTime = System.nanoTime();
            results.get(1).add(endTime - startTime);

            startTime = System.nanoTime();
            for (String s : str) {
                stringBuilder(s);
            }
            endTime = System.nanoTime();
            results.get(2).add(endTime - startTime);
        }

        long plusTime = 0;
        long concatTime = 0;
        long sbTime = 0;
        for (int i = 0; i < 1000; i++) {
            plusTime += results.get(0).get(i);
            if (plusTime < 0) {
                System.out.println("Bad");
            }
            concatTime += results.get(1).get(i);
            sbTime += results.get(2).get(i);
        }

        System.out.println("+=            " + plusTime / 1000);
        System.out.println("concat        " + concatTime / 1000);
        System.out.println("StringBuilder " + sbTime / 1000);


    }

    public static void stringBuilder(String str) {
        if (sb.length() == 653) {
            sb = new StringBuilder();
        }
        sb.append(str);
    }

    public static void concat(String str) {
        if (concatStr.length() == 653) {
            concatStr = "";
        }
        concatStr.concat(str);
    }

    public static void plus(String str) {
        if (plusStr.length() == 653) {
            plusStr = "";
        }
        plusStr += str;
    }
}


/*
Input1:

Expected output:

Input1:

Expected output:
 */