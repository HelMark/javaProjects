package encapsulation;

public class Digit { //dataorientert klasse
    private int base;  //base og value må være private for å sikre at de kun endres gjennom konstruktør / settere.
    private int value;

    private boolean validBase(int base) {   //Tilsvarende metode måtte legges til for å validere base. Må også være
        return base > 0;
    }

    public Digit(int base) {        //Legge til en validering som sjekker at ikke base er naganitiv
        if (!validBase(base)) {
            throw new IllegalArgumentException("Base cannot be negative");
        }
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