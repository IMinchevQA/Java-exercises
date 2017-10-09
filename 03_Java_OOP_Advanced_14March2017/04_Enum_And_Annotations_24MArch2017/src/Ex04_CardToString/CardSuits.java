package Ex04_CardToString;

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
