package Ex05_GenericCountMethodString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static Box<?> box = new BoxImpl<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String line = reader.readLine();

            Box<String> newBox = new BoxImpl<>(line);
            box.addBox(newBox);
        }

        String comparisonString = reader.readLine();

        System.out.println(box.compare(box.getListOfBoxes(), comparisonString));
    }
}

/*
Input 1:
3
aa
aaa
bb
aa

Expected output 1:
2

 */
