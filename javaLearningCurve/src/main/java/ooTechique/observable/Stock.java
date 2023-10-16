package ooTechique.observable;

import java.util.*;

public class Stock {
    
    private String ticker;
    private double price;
    private List<StockListener> listeners = new ArrayList<StockListener>();

    private boolean checkPrice(double price) {
        if (price <= 0) {
            return false;
        }
        return true;
    }

    public Stock(String ticker, double price) {
        this.ticker = ticker;
        this.price = price;
    }

    public void setPrice(double price) {
        if (!checkPrice(price)) {
            throw new IllegalArgumentException("Price cannot be negative or null");
        }
        for (StockListener listener : listeners) {
            listener.stockPriceChanged(this, this.getPrice(), price);
        }
        this.price = price;
    }

    public String getTicker() {
        return ticker;
    }

    public double getPrice() {
        return price;
    }

    public void addStockListener(StockListener listener) {
        listeners.add(listener);
    }

    public void removeStockListener(StockListener listener) {
        listeners.remove(listener);
    }
}
