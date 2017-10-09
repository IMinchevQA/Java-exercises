import java.util.*;

public class Ex08_HandsOfCards_27Jan2017 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        LinkedHashMap<String, HashSet<String>> playersAndCards = new LinkedHashMap<>();

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        while (true) {
            if(input.isEmpty() || "JOKER".equals(input)){
                break;
            }

            String[] personAndCards = input.split(": ");
            String player = personAndCards[0];
            String[] cards = personAndCards[1].split(", ");
            if(!playersAndCards.containsKey(player)){
                playersAndCards.put(player, new HashSet<>());
            }

            for(String card : cards){
                playersAndCards.get(player).add(card);
            }
            input = sc.nextLine();
        }


        for (String player : playersAndCards.keySet()) {
            System.out.printf("%1$s: %2$d", player, calcPoints(playersAndCards.get(player)));
            System.out.println();
        }

    }

    private static int calcPoints(HashSet<String> cards) {
        int points = 0;
        for (String card : cards) {
            String cardPower = card.substring(0, card.length()-1);
            String cardType = card.substring(card.length()-1, card.length());
            int cardPowerValue = 0;
            if(!Character.isDigit(cardPower.charAt(0))){
                switch(cardPower) {
                    case "J":
                        cardPowerValue = 11;
                        break;
                    case "Q":
                        cardPowerValue = 12;
                        break;
                    case "K":
                        cardPowerValue = 13;
                        break;
                    case "A":
                        cardPowerValue = 14;
                        break;
                }
            } else {
                cardPowerValue = Integer.parseInt(cardPower);
            }
            int cardTypeValue = 0;
            switch(cardType){
                case "S":
                    cardTypeValue = 4;
                    break;
                case "H":
                    cardTypeValue = 3;
                    break;
                case "D":
                    cardTypeValue = 2;
                    break;
                case "C":
                    cardTypeValue = 1;
                    break;
            }
            points += cardPowerValue * cardTypeValue;
        }

        return points;
    }
}

/*
Input
Pesho: 2C, 4H, 9H, AS, QS
Slav: 3H, 10S, JC, KD, 5S, 10S
Peshoslav: QH, QC, QS, QD
Slav: 6H, 7S, KC, KD, 5S, 10C
Peshoslav: QH, QC, JS, JD, JC
Pesho: JD, JD, JD, JD, JD, JD
JOKER

Expected output
Pesho: 167
Slav: 175
Peshoslav: 197


 */