package Ex05_CardCompareTo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CardRanks rankFirstCard = CardRanks.valueOf(reader.readLine());
        CardSuits suitFirstCard = CardSuits.valueOf(reader.readLine());
        CardRanks rankSecondCard = CardRanks.valueOf(reader.readLine());
        CardSuits suitSecondCard = CardSuits.valueOf(reader.readLine());

        Card card_1 = new Card(rankFirstCard, suitFirstCard);
        Card card_2 = new Card(rankSecondCard, suitSecondCard);

        Card biggerValueCard = card_1.compareTo(card_2) > 0 ? card_1 : card_2;

        System.out.println(biggerValueCard);

    }
}

/*
Input 1:
TWO
CLUBS
ACE
SPADES


Expected output 1:
Card name: ACE of SPADES; Card power: 53

 */
