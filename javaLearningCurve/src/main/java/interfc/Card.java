package interfc;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class Card implements Comparable<Card> {
    
    private char cardType;
    private int cardValue;

    private boolean isValidType(char cardType) {
        return cardType == 'H' || cardType == 'S' || cardType == 'D' || cardType == 'C';
    }
    private boolean isValidValue(int cardValue) {
        return cardValue >= 1 && cardValue <= 13;
    }

    public Card(char cardType, int cardValue) {
        if (!isValidType(cardType) || !isValidValue(cardValue))
            throw new IllegalArgumentException("Invalid card type or value");
        this.cardType = cardType;
        this.cardValue = cardValue;
    }

    public char getSuit() {
        return cardType;
    }
    public int getFace() {
        return cardValue;
    }
    @Override
    public String toString() {
        return cardType + "" + cardValue;
    }
    
    @Override
    public int compareTo(Card arg0) {
        if (this.getSuit() == arg0.getSuit()) {
            return this.getFace() - arg0.getFace();
        }
        return Character.compare(this.getSuit(), arg0.getSuit());
    }

    public static void main(String[] args) {
        Card s1 = new Card('S', 1);
		Card h1 = new Card('H', 1);
		Card d1 = new Card('D', 1);
		Card c1 = new Card('C', 1);
		Card s13 = new Card('S', 13);
		Card h13 = new Card('H', 13);
		Card d13 = new Card('D', 13);
		Card c13 = new Card('C', 13);
		ArrayList<Card> cards = new ArrayList<Card>(List.of(s1, s13, h1, h13, d1, d13, c1, c13));
        
        System.out.println(cards);

        Collections.sort(cards, new CardComparator(true, ' '));

        System.out.println(cards);
    }
}
