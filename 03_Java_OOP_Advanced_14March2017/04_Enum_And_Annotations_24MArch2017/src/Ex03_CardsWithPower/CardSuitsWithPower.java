package Ex03_CardsWithPower;

public enum CardSuitsWithPower {
     CLUBS(0), DIAMONDS(13), HEARTS(26), SPADES(39);

     private int suitPower;

     private CardSuitsWithPower(int suitPower) {
          this.suitPower = suitPower;
     }

     int getSuitPower() {
          return this.suitPower;
     }
}
