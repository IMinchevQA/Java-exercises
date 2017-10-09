package Ex02_CardRank;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Card Ranks: ");
        Stream.of(CardRanks.values()).forEach(r -> System.out.printf("Ordinal value: %s; Name value: %s%n", r.ordinal(), r.name()));
    }
}
