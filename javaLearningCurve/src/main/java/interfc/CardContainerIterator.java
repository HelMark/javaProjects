package interfc;

import java.util.*;

import associations.Card;

public class CardContainerIterator implements Iterator<Card> {
    
    private int numOfCards;
    private ArrayList<Card> cards = new ArrayList<Card>();
    private int index = 0;
    private Card posisjon;

    public CardContainerIterator(CardContainer container) {
        this.numOfCards = container.getCardCount();
        for (int i = 0; i < numOfCards; i++) {
            this.cards.add(container.getCard(i));
        }
    }

    @Override
    public boolean hasNext() {
        try {
            this.next();
            this.index--;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Card next() {
        if (index < numOfCards) {
            this.posisjon = cards.get(index);
            index++;
            return posisjon;
        } else {
            throw new NoSuchElementException();
        }
    }
    
}
