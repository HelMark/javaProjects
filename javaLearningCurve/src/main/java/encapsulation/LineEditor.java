package encapsulation;

public class LineEditor {   //dataorientert klasse
    private String text;    //Atributtene må være private for å sikre at de kun endres gjennom konstruktør / settere.
    private int insertionIndex;
    private int timesSetText;

    public LineEditor() {   //så det mest hensiksmessig å ikke legge til noen metoder for validrering av dataene
        this.text = "";
        this.insertionIndex = 0;
        this.timesSetText = 0;
    }

    public void left() {
        if (insertionIndex == 0) {
            return;    
        }
        insertionIndex -= 1;
    }
    public void right() {
        if (insertionIndex == this.text.length()) {
            return;
        }
        insertionIndex += 1;
    }

    public void insertString(String s) {
        this.text = this.text.substring(0, insertionIndex) + s + this.text.substring(insertionIndex);
        insertionIndex += s.length();
    }

    public void deleteLeft() {
        if (insertionIndex == 0) {
            return;    
        }
        this.text = this.text.substring(0, insertionIndex - 1) + this.text.substring(insertionIndex);
        insertionIndex -= 1;
    }
    public void deleteRight() {
        if (insertionIndex == this.text.length()) {
            return;
        }
        this.text = this.text.substring(0, insertionIndex) + this.text.substring(insertionIndex + 1);
    }

    public String getText() {
        return text;
    }
    public int getInsertionIndex() {
        return insertionIndex;
    }

    public void setText(String text) {
        this.text = text;
        this.timesSetText++;
        if (text.length() == 0) {
            insertionIndex = 0;
        } else if (timesSetText > 0) {  //endret på koden her slik at insertionIndex er på slutten av strengen hvis en bruker setter en ny tekst
            insertionIndex = text.length();
        }
        insertionIndex = text.length();
    }
    public void setInsertionIndex(int insertionIndex) {
        if(insertionIndex < 0 || insertionIndex > this.text.length()) { //Legge til en validering som sjekker insertionIndex ikke er negativ eller større enn lengden på teksten
            throw new IllegalArgumentException("Insertion index cannot be negative or larger than the length of the text");
        }
        this.insertionIndex = insertionIndex;
    }

    @Override
    public String toString() {
        return this.text.substring(0, insertionIndex) + "|" + this.text.substring(insertionIndex);
    }

    public static void main(String[] args) {
        LineEditor le = new LineEditor();
        le.setText("ABC");
        le.setText("");
        System.out.println(le);
        System.out.println(le.getInsertionIndex());
    }
}

