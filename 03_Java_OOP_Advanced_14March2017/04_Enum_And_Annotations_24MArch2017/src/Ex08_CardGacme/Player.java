package Ex08_CardGacme;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Player implements Comparable<Player> {
    private String name;
    private List<Card> cards;

    public Player(String name) {
        this.name = name;
        this.cards = new ArrayList<>();
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(cards);
    }

    public void addCard(Card card) {
        if (cards.size() != 0) {
          Card firstCard = cards.get(0);
          if(card.compareTo(firstCard) > 0) {
              cards.add(0, card);
          } else {
              cards.add(card);
          }
        } else {
            this.cards.add(card);
        }
    }

    public Card getMaxCard() {
        return this.cards.get(0);
    }

    @Override
    public int compareTo(Player otherPlayer) {
        return this.getMaxCard().compareTo(otherPlayer.getMaxCard());
    }

    @Override
    public String toString() {
        return String.format("%s wins with %s of %s.", this.name, this.getMaxCard().getRank(), this.getMaxCard().getSuit());
    }
}
