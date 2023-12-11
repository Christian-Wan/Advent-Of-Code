import java.util.Arrays;
import java.util.HashMap;

public class Year23_Day07_Object {
    private String type;
    private String cards;
    private int bid;

    public Year23_Day07_Object(String cards, int bid) {
        this.cards = cards;
        this.bid = bid;
        type = findType();
    }

    public String findType() {
        HashMap<Character, Integer> thing = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            thing.putIfAbsent(cards.charAt(i), 0);
            thing.replace(cards.charAt(i), thing.get(cards.charAt(i)) + 1);
        }
        thing.remove('J');
        if (thing.isEmpty()) {
            thing.put('A', 1);
        }
        String[] amount = Arrays.toString(thing.values().toArray()).substring(1, Arrays.toString(thing.values().toArray()).length() - 1).split(", ");
        Arrays.sort(amount);
        int count = 0;
        for (int i = 0; i < amount.length; i++) {
            count += Integer.parseInt(amount[i]);
        }
        if (count < 5) {
            amount[amount.length - 1] = Integer.toString(Integer.parseInt(amount[amount.length - 1]) + (5 - count));
        }
        if (thing.size() == 1) {
            return "Five";
        }
        if (thing.size() == 2 && Integer.parseInt(amount[0]) * Integer.parseInt(amount[1]) == 4) {
            return "Four";
        }
        if (thing.size() == 2 && Integer.parseInt(amount[0]) * Integer.parseInt(amount[1]) == 6) {
            return "Full";
        }
        if (thing.size() == 3 && (Integer.parseInt(amount[0]) * Integer.parseInt(amount[1]) * Integer.parseInt(amount[2])) == 3) {
            return "Three";
        }
        if (thing.size() == 3 && (Integer.parseInt(amount[0]) * Integer.parseInt(amount[1]) * Integer.parseInt(amount[2])) == 4) {
            return "Two";
        }
        if (thing.size() == 5) {
            return "High";
        }
        return "One";
    }

    public String getType() {
        return type;
    }

    public String getCards() {
        return cards;
    }

    public static boolean firstBeatsSecond(Year23_Day07_Object hand1, Year23_Day07_Object hand2) {
        String typeRanking = "Five Four Full Three Two One High";
        String cardRanking = "A K Q T 9 8 7 6 5 4 3 2 J";
        if (typeRanking.indexOf(hand1.getType()) < typeRanking.indexOf(hand2.getType())) {
            return true;
        }
        else if (typeRanking.indexOf(hand1.getType()) > typeRanking.indexOf(hand2.getType())) {
            return false;
        }
        else {
            for (int i = 0; i < 5; i++) {
                if (cardRanking.indexOf(hand1.getCards().charAt(i)) < cardRanking.indexOf(hand2.getCards().charAt(i))) {
                    return true;
                }
                else if (cardRanking.indexOf(hand1.getCards().charAt(i)) > cardRanking.indexOf(hand2.getCards().charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getBid() {
        return bid;
    }
}
