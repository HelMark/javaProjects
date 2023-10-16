package simplePrograms;
import java.util.*;

public class RPNCalc {
    private List<Double> stack;

    public RPNCalc() {
        this.stack = new ArrayList<>();
    }

    public void push(double value) {
        stack.add(0, value);
    }
    public double pop() {
        if (stack.size() == 0) {
            return Double.NaN;
        }
        double value = stack.get(0);
        stack.remove(0);
        return value;
    }
    public double peek(int value) {
        if (stack.size() <= value || value < 0) {
            return Double.NaN;
        }
        return stack.get(value);
    }
    public int getSize() {
        return stack.size();
    }
    public void performOperation(char x) {
        double a = pop();
        double b = pop();
        switch (x) {
            case '+':
                push(a + b);
                break;
            case '-':
                push(b - a);
                break;
            case '*':
                push(a * b);
                break;
            case '/':
                push(b / a);
                break;
            case '^':
                push(Math.pow(a, b));
                break;
            default:
                System.out.println("Invalid operation");
        }
    }
    public static void main(String[] args) {
        RPNCalc calc = new RPNCalc();
        calc.push(1.0);
        calc.push(2.0);
        System.out.println(calc.peek(0));
    
        /*Teori
        *  - For .peek() ser jeg det hensiktsmessig å bruke IllegalArgumentException siden det er en feil i argumentet som blir bestemmer om metoden gjennomføres.
        *  - For .pop() ser jeg det hensiktsmessig å brukeIllegalStateException siden det er en feil i tilstanden til objektet som bestemmer om metoden gjennomføres.
        *   -> Fordelen med disse alternativet er at vi stykker opp koden mer slik at vi kan gjennbruke slike valideringsmetoder ia andre klasser, og at ved en 
               IllegalArgumentException/IllegalStateException vil vi få en mer detaljert feilmelding og en stopp i koden. Ulempen er kansje at vi må skrive mer kode for å få til dette.

           - For manglende operand for * eller / kan vi bruke IllegalArgumentException siden det er en feil i argumentet som bestemmer om metoden gjennomføres siden det ikke gir
             særlig mening å bruke en operator som tar inn to verdier uten å ha to verdier å bruke.
        *  - En kan endre stack-operasjonene slik at en sikrer seg å ha to operander for operatorer som tar inn to verdier. Her tror jeg det er hensiktsmessig å bruke IllegalStateException.
         */
    }
}
