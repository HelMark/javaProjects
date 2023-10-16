package javaSyntax;

public class Location {
    private int x;
    private int y;
    
    //Constructor
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
    //Getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    //Other methods
    public int up() {
        return this.y--;
    }
    
    public int down() {
        return this.y++;
    }

    public int right() {
        return this.x++;
    }

    public int left() {
        return this.x--;
    }

    public static void main(String[] args) {
        Location p = new Location(2, 5);
        
        System.out.println("(" + p.getX() + "," + p.getY() + ")"); 

        p.up();
        System.out.println("(" + p.getX() + "," + p.getY() + ")"); 

        p.down();
        System.out.println("(" + p.getX() + "," + p.getY() + ")"); 

        p.right();
        System.out.println("(" + p.getX() + "," + p.getY() + ")"); 

        p.left();
        System.out.println("(" + p.getX() + "," + p.getY() + ")"); 
    }
}
