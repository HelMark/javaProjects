package associations;
import java.util.*;
import java.util.function.Predicate;

import interfc.CardContainer;
import interfc.CardContainerIterator;

public class CardDeck<T> implements CardContainer, Predicate<T>{

    private List<Character> suits = Arrays.asList('S', 'H', 'D', 'C');
    private ArrayList<Card> cardDeck;
    
    private boolean isValidNumber(int n) {
        return n >= 0 && n <= 13;
    }
    private boolean isValidNumber4Index(int n) {
        return n >= 0 && n <= getCardCount();
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
    //From intreface
    @Override
    public int getCardCount() {
        return cardDeck.size();
    }
    @Override
    public Card getCard(int n) {
        if (!isValidNumber4Index(n)) {
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

    public void deal(CardHand hand, int n) {
        for (int i = 0; i < n; i++) {
            int cardIndex = getCardCount() - 1;
            hand.addCard(getCard(cardIndex));
            cardDeck.remove(cardIndex);
        }
    }

    @Override
    public String toString() {
        return cardDeck.toString();
    }
    
    @Override
    public CardContainerIterator iterator() {
        return new CardContainerIterator(this);
    }
    @Override
    public boolean test(T t) {
        for (Card card : cardDeck) {
            if (card.getSuit() == 'S' && card.getFace() == 12) {
                return true;
            }
        }
        return false;
    }
     
    public static void main(String[] args) {
        //CardDeck deck2 = new CardDeck(-1);
        //CardDeck deck3 = new CardDeck(14);
        /*
        CardDeck deck = new CardDeck(2);
        System.out.println(deck);
        System.out.println(deck.getCardCount());
        System.out.println(deck.getCard(0));
        deck.shufflePerfectly();
        System.out.println(deck);


        CardDeck deck = new CardDeck(1);
        CardHand hand = new CardHand();
        System.out.println(deck.getCardCount());
        System.out.println(deck);
        deck.deal(hand, 3);
        System.out.println(deck);
        System.out.println(hand);
    */
    }
}
