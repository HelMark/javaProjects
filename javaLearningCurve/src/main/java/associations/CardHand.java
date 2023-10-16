package associations;

import java.util.*;

import interfc.CardContainer;
import interfc.CardContainerIterator;

public class CardHand implements CardContainer{
    private ArrayList<Card> cardHand;

    private boolean isValidNumber(int n) {
        return n >= 0 && n <= 13;
    }
    private boolean isValidNumber4Index(int n) {
        return n >= 0 && n <= getCardCount();
    }

    //Constructor
    public CardHand() {
        cardHand = new ArrayList<Card>();
    }
    //Other
    //From interface
    @Override
    public int getCardCount() {
        return cardHand.size();
    } 
    @Override
    public Card getCard(int n) {
        if (!isValidNumber4Index(n)) {
            throw new IllegalArgumentException("Invalid card number");
        }
        return cardHand.get(n);
    }
    //add/play
    public void addCard(Card c) {
        cardHand.add(c);
    }
    public Card play(int n) {
        if (!isValidNumber(n)) {
            throw new IllegalArgumentException("Invalid card number");
        }
        return cardHand.remove(n);
    }
    @Override
    public String toString() {
        return cardHand.toString();
    }
    

    public static void main(String[] args) {
        CardHand p = new CardHand();
        System.out.println(p);
    }
    @Override
    public CardContainerIterator iterator() {
        return new CardContainerIterator(this);
    }
}
