package Ex01_CardSuits;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Card Suits: ");
        Stream.of(CardSuits.values()).forEach(s -> System.out.printf("Ordinal value: %s; Name value: %s%n", s.ordinal(), s.name()));
    }
}
