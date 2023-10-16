package associations;

public class Card {
    
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

    public static void main(String[] args) {
        Card card = new Card('S', 1);
        System.out.println(card);
    }
}
