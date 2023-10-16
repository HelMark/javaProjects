package simplePrograms;
import java.util.*;
public class CardDeck {

    private List<Character> suits = Arrays.asList('S', 'H', 'D', 'C');

    private ArrayList<Card> cardDeck;
    
    private boolean isValidNumber(int n) {
        return n >= 0 && n <= 13;
    }
    
    public CardDeck(int n) {
        if (!isValidNumber(n)) {
            throw new IllegalArgumentException("Invalid card number");
        }
        cardDeck = new ArrayList<Card>();
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < n + 1; j++) {
                cardDeck.add(new Card(suits.get(i), j));
            }
        }
    }

    public int getCardCount() {
        return cardDeck.size();
    }
    public Card getCard(int n) {
        if (!isValidNumber(n)) {
            throw new IllegalArgumentException("Invalid card number");
        }
        return cardDeck.get(n);
    }

    public void shufflePerfectly() {
        ArrayList<Card> shuffledDeck = new ArrayList<Card>();
        for (int i = 0; i < cardDeck.size(); i++) {
            if (i % 2 == 0) {
                shuffledDeck.add(cardDeck.get(i / 2));
            } else {
                shuffledDeck.add(cardDeck.get(cardDeck.size() / 2 + i / 2));
            }
        }
        cardDeck = shuffledDeck;
    }
    
    @Override
    public String toString() {
        return cardDeck.toString();
    } 
    public static void main(String[] args) {
        //CardDeck deck2 = new CardDeck(-1);
        //CardDeck deck3 = new CardDeck(14);
        
        CardDeck deck = new CardDeck(2);
        System.out.println(deck);
        System.out.println(deck.getCardCount());
        System.out.println(deck.getCard(0));
        deck.shufflePerfectly();
        System.out.println(deck);
    }
}
