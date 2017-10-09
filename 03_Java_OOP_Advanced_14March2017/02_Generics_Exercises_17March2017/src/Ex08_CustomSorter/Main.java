package Ex08_CustomSorter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    @SuppressWarnings("unchecked")
    private static CustomList<String> customList = new CustomListImpl<>();
    private static Sortable<String> sorter = new Sorter<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        executeReadInput(reader);

    }

    private static void executeReadInput(BufferedReader reader) throws IOException {
        String line = "";
        String[] lineTokens = null;

        while (!"END".equals(line = reader.readLine())) {
            lineTokens = line.trim().split("\\s+");
            switch (lineTokens[0].toLowerCase()) {
                case "add":
                    customList.add(lineTokens[1]);
                    break;
                case "remove":
                    customList.remove(Integer.parseInt(lineTokens[1]));
                    break;
                case "contains":
                    System.out.println(customList.contains(lineTokens[1]));
                    break;
                case "swap":
                    customList.swap(Integer.parseInt(lineTokens[1]), Integer.parseInt(lineTokens[2]));
                    break;
                case "greater":
                    System.out.println(customList.countGreatherThat(lineTokens[1]));
                    break;
                case "max":
                    System.out.println(customList.getMax());
                    break;
                case "min":
                    System.out.println(customList.getMin());
                    break;
                case "sort":
                    customList = sorter.sort(customList);
                    break;
                case "print":
                    System.out.println(customList);
                    break;
            }
        }
    }

}

/*
Input 1:
Add cc
Add bb
Add aa
Sort
Print
END


Expected output 1:
aa
bb
cc



 */
