package ooTechique.observable;

public class StockMain {
    public static void main(String[] args) {
        Stock appleStock = new Stock("Apple", 100.0);
        Stock microsoftStock = new Stock("Microsoft", 120.0);
        Stock googleStock = new Stock("Google", 200.0);

        StockIndex index = new StockIndex("Apple, Microsoft, Google", appleStock, microsoftStock, googleStock);

        System.out.println(index.getIndex());
        
        Stock tesla = new Stock("Tesla", 150.0);
        googleStock.setPrice(190.0);
        index.addStock(tesla);

        System.out.println(index.getIndex());
    }
}
