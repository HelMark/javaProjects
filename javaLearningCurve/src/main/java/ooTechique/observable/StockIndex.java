package ooTechique.observable;

import java.util.*;

public class StockIndex implements StockListener {

    private double index;
    private ArrayList<Stock> stocks = new ArrayList<Stock>();

    public StockIndex(String name, Stock... stocks) {
        for (Stock stock : stocks) {
            this.stocks.add(stock);
        }
    }

    public void addStock(Stock stock) {
        if (!stocks.contains(stock)) {
            stocks.add(stock);
        }
        
    }

    public void removeStock(Stock stock) {
        stocks.remove(stock);
    }

    public double getIndex() {
        this.index = 0;
        for (Stock stock : stocks) {
            this.index += stock.getPrice();
        }
        return this.index;
    }

    @Override
    public void stockPriceChanged(Stock stock, double oldValue, double newValue) {
        for (Stock s : stocks) {
            if (s.getTicker().equals(stock.getTicker())) {
                s = stock;
            }
        }
    }
}
