package associations;

import java.util.*;

public class Merchant {
    
    private ArrayList<Item> inventory;
    private double money;

    public Merchant(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        this.money = money;
        this.inventory = new ArrayList<Item>();
    }

    public void obtainItem(Item item) {
        inventory.add(item);
    }

    public void removeItem(Item item) {
        inventory.remove(item);
    }

    public void sellItem(Item item, Merchant buyer) {
        if(!(this.inventory.contains(item) && buyer.getBalance() >= item.getPrice() && this != buyer)) {
            throw new IllegalStateException("Invelid transaction");
        }
        item.changeOwner(buyer);
        buyer.obtainItem(item);
        this.removeItem(item);
        this.money += item.getPrice();
        buyer.money -= item.getPrice();
    }

    public void itemSale(double sale, Item item) {
        if (!(inventory.contains(item) && sale > 0 && sale < 1)) {
            throw new IllegalStateException("Item not in inventory");
        }
        item.setPrice(item.getPrice() * sale);
    }

    public void inventorySale(double sale) {
        for (Item item : inventory) {
            this.itemSale(sale, item);
        }
    }

    //egne metoder
    public double getBalance() {
        return money;
    }

    public Collection<Item> getInventory() {
        return inventory;
    }

    public static void main(String[] args) {
        Merchant merchant1 = new Merchant(100);
        Merchant merchant2 = new Merchant(100);

        Item item1 = new Item("Sword", "Weapon", 10);

        merchant1.obtainItem(item1);
        merchant1.sellItem(item1, merchant2);
    }

}
