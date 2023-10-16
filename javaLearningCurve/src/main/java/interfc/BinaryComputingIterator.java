package interfc;

import java.util.*;
import java.util.function.*;

public class BinaryComputingIterator {

    private Iterator<Double> iterator1;
    private Iterator<Double> iterator2;
    private Double default1;
    private Double default2;
    private BinaryOperator<Double> operator;

    public BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2, BinaryOperator<Double> operator) {
        this.iterator1 = iterator1;
        this.iterator2 = iterator2;
        this.operator = operator;        
    }

    public BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2, Double default1, Double default2, BinaryOperator<Double> operator) {
        this.iterator1 = iterator1;
        this.iterator2 = iterator2;
        this.default1 = default1;
        this.default2 = default2;
        this.operator = operator;
    }

    public boolean hasNext() {
        if (iterator2.hasNext() == false && default2 == null) {
            return false;
        } else if (iterator1.hasNext() == false && default1 == null) {
            return false;
        }
        return iterator1.hasNext() || iterator2.hasNext();
    }

    public Double next() {
        if (!iterator1.hasNext()) {
            return operator.apply(default1, iterator2.next());
        } else if (!iterator2.hasNext()) {
            return operator.apply(iterator1.next(), default2);
        }
        return operator.apply(iterator1.next(), iterator2.next());
    }

    public Double apply(Double t, Double u) {
        return operator.apply(t, u);
    }
    
    public static void main(String[] args) {
        Iterator<Double> iterator1 = Arrays.asList(2.0,3.0).iterator();
        Iterator<Double> iterator2 = Arrays.asList(5.0).iterator();
        Iterator<Double> iterator3 = Arrays.asList(0.5, -2.0).iterator();
        Iterator<Double> iterator4 = Arrays.asList(5.0).iterator();

        BinaryOperator<Double> operator = (a,b) -> a+b;

        BinaryComputingIterator bci = new BinaryComputingIterator(iterator1, iterator2, null, 10.0, operator);

        System.out.println(bci.next());
        System.out.println(bci.hasNext());
        System.out.println(bci.next());
        System.out.println(bci.hasNext());

        BinaryComputingIterator bic2 = new BinaryComputingIterator(iterator3, iterator4, (a, b) -> a * b);
        System.out.println(bic2.next());
        System.out.println(bic2.hasNext());


    }
}
