package interfc;

import java.util.Comparator;

public class CardComparator implements Comparator<Card>{
    
    private boolean aceIsBiggest;
    private char trumf;

    
    public CardComparator(boolean aceIsBiggest, char trumf) {
        this.aceIsBiggest = aceIsBiggest;
        this.trumf = trumf;
    }

    @Override
    public int compare(Card o1, Card o2) {
       if (aceIsBiggest) {
        switch (trumf) {
            case ' ':
            if (o1.getFace() == 13 || o2.getFace() == 13) {
                if (o1.getFace() == 13) {
                    return -1;
                } else if (o2.getFace() == 13) {
                    return -1;
                }
            }
                return o1.compareTo(o2);
            case 'C':
                if (o1.getSuit() == 'C') {
                    return 1;
                } else if (o2.getSuit() == 'C') {
                    return -1;
                } else {
                    return o1.compareTo(o2);
                }
            case 'D':
                if (o1.getSuit() == 'D') {
                    return 1;
                } else if (o2.getSuit() == 'D') {
                    return -1;
                } else {
                    return o1.compareTo(o2);
                }
            case 'H':
                if (o1.getSuit() == 'H') {
                    return 1;
                } else if (o2.getSuit() == 'H') {
                    return -1;
                } else {
                    return o1.compareTo(o2);
                }
            case 'S':
                if (o1.getSuit() == 'S') {
                    return 1;
                } else if (o2.getSuit() == 'S') {
                    return -1;
                } else {
                    return o1.compareTo(o2);
                }
            default:
                throw new IllegalArgumentException("Invalid trumf");
        }
        }
            switch (trumf) {
            case ' ':
                 return o1.compareTo(o2);
            case 'C':
                 if (o1.getSuit() == 'C') {
                      return 1;
                 } else if (o2.getSuit() == 'C') {
                      return -1;
                 } else {
                      return o1.compareTo(o2);
                 }
            case 'D':
                 if (o1.getSuit() == 'D') {
                      return 1;
                 } else if (o2.getSuit() == 'D') {
                      return -1;
                 } else {
                      return o1.compareTo(o2);
                 }
            case 'H':
                 if (o1.getSuit() == 'H') {
                      return 1;
                 } else if (o2.getSuit() == 'H') {
                      return -1;
                 } else {
                      return o1.compareTo(o2);
                 }
            case 'S':
                 if (o1.getSuit() == 'S') {
                      return 1;
                 } else if (o2.getSuit() == 'S') {
                      return -1;
                 } else {
                      return o1.compareTo(o2);
                 }
            default:
                 throw new IllegalArgumentException("Invalid trumf");
          }
     }
    }
