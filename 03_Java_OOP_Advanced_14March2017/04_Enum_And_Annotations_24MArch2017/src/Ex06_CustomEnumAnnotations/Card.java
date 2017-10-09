package Ex06_CustomEnumAnnotations;

public class Card implements Comparable<Card> {
    private CardRanks rank;
    private CardSuits suit;
    private int cardPower;



    public Card(CardRanks rank, CardSuits suit) {
        this.rank = rank;
        this.suit = suit;
        this.cardPower = this.calculatePower();

    }

    public int getCardPower() {
        return this.cardPower;
    }

    public CardSuits getSuit() {
        return this.suit;
    }

    public CardRanks getRank() {
        return this.rank;
    }

    private int calculatePower() {
        int valueCardRank = Enum.valueOf(CardRanks.class, this.getRank().name()).getPower();
        int valueCardSuit = Enum.valueOf(CardSuits.class, this.getSuit().name()).getSuitPower();
        return valueCardRank + valueCardSuit;
    }


    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %s", this.getRank().name(), this.getSuit().name(), this.calculatePower());
    }

    @Override
    public int compareTo(Card other) {
        return Integer.compare(this.getCardPower(), other.getCardPower());
    }
}

