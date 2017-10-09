package Ex04_CardToString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CardRanks rank = CardRanks.valueOf(reader.readLine());
        CardSuits suit = CardSuits.valueOf(reader.readLine());

        Card card = new Card(rank, suit);

        System.out.printf(card.toString());
    }
}

/*
Input 1:
TWO
CLUBS

Expected output 1:
Card name: TWO of CLUBS; Card power: 2


Input 2:
ACE
SPADES

Expected output 2:
Card name: ACE of SPADES; Card power: 53
 */
