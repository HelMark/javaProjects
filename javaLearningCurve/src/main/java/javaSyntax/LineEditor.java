package javaSyntax;

public class LineEditor {
    String text;
    int insertionIndex;

    public LineEditor() {
        this.text = "";
        this.insertionIndex = 0;
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
    }
    public void setInsertionIndex(int insertionIndex) {
        this.insertionIndex = insertionIndex;
    }

    @Override
    public String toString() {
        return this.text.substring(0, insertionIndex) + "|" + this.text.substring(insertionIndex);
    }

    public static void main(String[] args) {
        LineEditor le = new LineEditor();
        le.right();
        System.out.println(le);
    }
}

