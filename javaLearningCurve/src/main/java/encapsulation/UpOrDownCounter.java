package encapsulation;

public class UpOrDownCounter {  //dataorientert klasse
    private int counter;    //counter og end må være private for å sikre at de kun endres gjennom konstruktør / settere.
    private int end;

    private boolean validNnumbers(int counter, int end) {   //Tilsvarende metode måtte legges til for å validere counter og end. Må også være private.
        return counter == end ? true:false;
    }

    public UpOrDownCounter(int counter, int end) {  //Legge til en validering som sjekker at ikke counter og end ikkke  er naganitiv
        if (this.validNnumbers(counter, end)){
            throw new IllegalArgumentException("Start and end cannot be equal");
        }
        this.counter = counter;
        this.end = end;
    }

    public int getCounter() {
        return counter;
    }

    public boolean count(){
        if(this.counter > this.end) {
            this.counter -= 1;
            return counter > end;
        } else if (this.counter < this.end) {
            this.counter += 1;
            return counter < end;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        UpOrDownCounter one = new UpOrDownCounter(12, 5);
        UpOrDownCounter two = new UpOrDownCounter(24, 25);
        try {
            UpOrDownCounter three = new UpOrDownCounter(14, 14);
            System.out.println(three.getCounter());
        } catch (Exception e) {
        }

        System.out.println(one.getCounter());

        one.count();
        two.count();
        
        System.out.println(one.getCounter());
        System.out.println(two.getCounter());
        
        two.count();
        System.out.println(two.getCounter());
    }
}
