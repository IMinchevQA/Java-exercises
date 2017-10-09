package Ex01_GenericBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            Box<String> box = new BoxImpl<>(reader.readLine());
            System.out.println(box);
        }
    }
}


/*
Input 1:
2
life in a box
box in a life


Expected output 1:
java.lang.String: life in a box
java.lang.String: box in a life


 */