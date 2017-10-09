package Ex09_CollectionHierarchy;

import Ex09_CollectionHierarchy.implementation.AddCollectionImpl;
import Ex09_CollectionHierarchy.implementation.AddRemoveCollectionImpl;
import Ex09_CollectionHierarchy.implementation.MyListImpl;
import Ex09_CollectionHierarchy.interfaces.Addable;
import Ex09_CollectionHierarchy.interfaces.Removable;
import Ex09_CollectionHierarchy.interfaces.Usable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Addable addable = new AddCollectionImpl();
        Removable removable = new AddRemoveCollectionImpl();
        Usable usable = new MyListImpl();

        String[] inputTokens = reader.readLine().trim().split("\\s+");

        Stream.of(inputTokens).forEach(a -> System.out.print(addable.add(a) + " "));
        System.out.println();
        Stream.of(inputTokens).forEach(r -> System.out.print(removable.add(r) + " "));
        System.out.println();
        Stream.of(inputTokens).forEach(u -> System.out.print(usable.add(u) + " "));
        System.out.println();

        int lines = Integer.parseInt(reader.readLine());

        for (int i = 0; i < lines; i++) {
            System.out.print(removable.remove() + " ");
        }
        System.out.println();

        for (int i = 0; i < lines; i++) {
            System.out.print(usable.remove() + " ");
        }
        System.out.println();
    }
}

/*
Input 1:
banichka boza tutmanik
3

Expected output 1:
0 1 2
0 0 0
0 0 0
banichka boza tutmanik
tutmanik boza banichka


Input 2:
one two three four five six seven
4

Expected output 2:
0 1 2 3 4 5 6
0 0 0 0 0 0 0
0 0 0 0 0 0 0
one two three four
seven six five four


 */
