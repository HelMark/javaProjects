package javaSyntax;

public class Digit {
    private int base;
    private int value;

    public Digit(int base) {
        this.base = base;
        this.value = 0;
    }

    public int getValue() {
        return value;
    }
    public boolean increment() {
        if (value < base - 1) {
            value++;
            return false;
        } else {
            value = 0;
            return true;
        }
    }
    public int getBase() {
        return base;
    }

    @Override
    public String toString() {
        if (base > 9 && value > 9) {
            return String.valueOf((char) (value + 55));
        } else {
            return String.valueOf(value);
        }
    }

    public static void main(String[] args) {
        Digit p = new Digit(15);

        p.increment();

        System.out.println(p.toString());
    }
}