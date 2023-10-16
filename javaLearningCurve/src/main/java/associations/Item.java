package associations;

public class Item {
    private String type;
    private double price;
    private Merchant owner;

    private boolean isValidType(String type) {
        return type.equals("Weapon") || type.equals("Armour") || type.equals("Potion") || type.equals("Valuable");
    }

    public Item(String name, String type, double price) {
        if (!(isValidType(type) || name.equals("") || price > 0)) {
            throw new IllegalArgumentException("Invalid input");
        }
        this.type = type;
        this.price = price;
        this.owner = null;
    }

    public Merchant getOwner() {
        return owner;
    }

    public void changeOwner(Merchant owner) {
        this.owner = owner;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        this.price = price;
    }
    
    @Override
    public String toString() {
        return this.type + ":" + this.price + " owned by " + this.owner;
    }
}
