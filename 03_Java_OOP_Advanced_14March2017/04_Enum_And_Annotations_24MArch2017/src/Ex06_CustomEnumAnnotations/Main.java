package Ex06_CustomEnumAnnotations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        CardRanks rankFirstCard = CardRanks.valueOf(reader.readLine());
//        CardSuits suitFirstCard = CardSuits.valueOf(reader.readLine());
//        CardRanks rankSecondCard = CardRanks.valueOf(reader.readLine());
//        CardSuits suitSecondCard = CardSuits.valueOf(reader.readLine());
//
//        Card card_1 = new Card(rankFirstCard, suitFirstCard);
//        Card card_2 = new Card(rankSecondCard, suitSecondCard);
//
//        Card biggerValueCard = card_1.compareTo(card_2) > 0 ? card_1 : card_2;
//
//        System.out.println(biggerValueCard);

        EnumAnnotation rankInfo = CardRanks.class.getAnnotation(EnumAnnotation.class);
        EnumAnnotation suitInfo = CardSuits.class.getAnnotation(EnumAnnotation.class);

        String input = reader.readLine();

        switch(input) {
            case "Rank":
                System.out.printf("Type = %s, Description = %s%n", rankInfo.type(), rankInfo.description());
                break;
            case "Suit":
                System.out.printf("Type = %s, Description = %s%n", suitInfo.type(), suitInfo.description());
        }




    }
}

/*
Input 1:
Rank

Expected output 1:
Type = Enumeration, Description = Provides rank constants for a Card class.




Input 2:
Suit

Expected output 2:
Type = Enumeration, Description = Provides suit constants for a Card class.

 */
