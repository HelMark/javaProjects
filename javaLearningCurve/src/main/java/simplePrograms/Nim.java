package simplePrograms;

import java.util.ArrayList;

public class Nim {

    private ArrayList<Integer> bricksToRemove;
    
    public Nim() {
        bricksToRemove  = new ArrayList<Integer>();
        bricksToRemove.add(10);
        bricksToRemove.add(10);
        bricksToRemove.add(10);
    }
    public Nim(int pileSize) {
        bricksToRemove  = new ArrayList<Integer>();
        bricksToRemove.add(pileSize);
        bricksToRemove.add(pileSize);
        bricksToRemove.add(pileSize);
    }

    public boolean validStatOrArgment(int number, int targetPile) {
        if (isGameOver()) {
            throw new IllegalStateException("Game ended");
        } else if (!(number > 0 && number <= this.bricksToRemove.get(targetPile))) {
            throw new IllegalArgumentException("Illegal pile number");
        }
            return true;
    }

    public boolean isValidMove(int number, int targetPile) {
        if (isGameOver()) {
            return false;
        } else if (!(number > 0 && number <= this.bricksToRemove.get(targetPile))) {
            return false;
        }
            return true;
    }

    public void removePieces(int number, int targetPile) {
        if (validStatOrArgment(number, targetPile)) {
            int x = this.bricksToRemove.get(targetPile) - number;
            this.bricksToRemove.set(targetPile, x);
        }
    }

    public boolean isGameOver() {
        if (this.bricksToRemove.get(0) == 0 || this.bricksToRemove.get(1) == 0 || this.bricksToRemove.get(2) == 0) {
            return true;
        }
        return false;
    }

    public int getPile(int targetPile) {
        return this.bricksToRemove.get(targetPile);
    }

    @Override
    public String toString() {
        return "Pile 1: " + this.bricksToRemove.get(0) + "\n" + "Pile 2: " + this.bricksToRemove.get(1) + "\n" + "Pile 3: " + this.bricksToRemove.get(2);
    }

    public static void main(String[] args) {
        Nim nim = new Nim();
        System.out.println(nim);
        nim.removePieces(2, 0);
    }
}
