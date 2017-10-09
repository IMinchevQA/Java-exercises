package Ex03_CardsWithPower;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String card = reader.readLine();
        String suit = reader.readLine();

        int cardValue = Enum.valueOf(CardsWithPower.class, card).getCardPower() + Enum.valueOf(CardSuitsWithPower.class, suit).getSuitPower();

        System.out.printf("Card name: %s of %s; Card power: %s", card, suit, cardValue);
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
