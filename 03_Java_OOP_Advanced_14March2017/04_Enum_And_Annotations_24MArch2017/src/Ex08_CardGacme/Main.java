package Ex08_CardGacme;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
   private static HashSet<Card> cardsTakenFromTheDeck = new HashSet<>();
   private static Player player_1;
   private static Player player_2;
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

//        EnumAnnotation rankInfo = CardRanks.class.getAnnotation(EnumAnnotation.class);
//        EnumAnnotation suitInfo = CardSuits.class.getAnnotation(EnumAnnotation.class);
//
//        String input = reader.readLine();
//
//        switch(input) {
//            case "Rank":
//                System.out.printf("Type = %s, Description = %s%n", rankInfo.type(), rankInfo.description());
//                break;
//            case "Suit":
//                System.out.printf("Type = %s, Description = %s%n", suitInfo.type(), suitInfo.description());
//        }
//
//        Stream.of(CardSuits.values())
//                .forEach(s -> Stream.of(CardRanks.values())
//                .forEach(r -> System.out.printf("%s of %s%n", r, s)));

        player_1 = new Player(reader.readLine());
        player_2 = new Player(reader.readLine());

        addCards(player_1, reader);
        addCards(player_2, reader);

        System.out.println(player_1.compareTo(player_2) > 0 ? player_1 : player_2);


    }

    private static void addCards(Player player, BufferedReader reader) throws IOException {
        Card card = null;
        while (player.getCards().size() < 5) {
            String[] cardTokens = reader.readLine().trim().split("\\s+");
            try {
                card = new Card(CardRanks.valueOf(cardTokens[0]), CardSuits.valueOf(cardTokens[2]));
            } catch (IllegalArgumentException iaex) {
                System.out.println("No such card exists.");
                continue;
            }

            if (cardsTakenFromTheDeck.contains(card)) {
                System.out.println("Card is not in the deck.");
                continue;
            }

            player.addCard(card);
            cardsTakenFromTheDeck.add(card);
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



Input 3:
Card Deck

Expected output 3:
ACE of CLUBS
TWO of CLUBS
THREE of CLUBS
FOUR of CLUBS
FIVE of CLUBS
...
...
...
KING of SPADES

Input 4:
Ivo
Gosho
QUEEN of DIAMONDS
KING of DIAMONDS
ACE of HEARTS
ACE of HEARTS
spades of ace
TWO of HEARTS
THREE of HEARTS
FOUR of HEARTS
FIVE of HEARTS
SIX of HEARTS
SEVEN of HEARTS
EIGHT of HEARTS


Expected output 4:
Card is not in the cardsTakenFromTheDeck.
No such card exists.
Ivo wins with ACE of HEARTS.




 */
