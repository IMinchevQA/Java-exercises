package Ex07_DeckOfCards;

@EnumAnnotation(
        category = "Suit",
        description = "Provides suit constants for a Card class."
)

public enum CardSuits {
     CLUBS(0), DIAMONDS(13), HEARTS(26), SPADES(39);

     private int suitPower;

     private CardSuits(int suitPower) {
          this.suitPower = suitPower;
     }

     int getSuitPower() {
          return this.suitPower;
     }
}
