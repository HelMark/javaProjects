package interfc;
import associations.Card;
public interface CardContainer extends Iterable<Card> {
    
    public int getCardCount();
    public Card getCard(int n);

    public CardContainerIterator iterator();
    
}
