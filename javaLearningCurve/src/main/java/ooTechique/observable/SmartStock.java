package ooTechique.observable;

import java.util.*;

public class SmartStock extends Stock{

    private HashMap<StockListener, Double> min = new HashMap<StockListener, Double>();
    private HashMap<StockListener, Double> max = new HashMap<StockListener, Double>();
    private boolean isDifferencePendent = false;
    private ArrayList<Double> priceHistory = new ArrayList<Double>();

    public SmartStock(String ticker, double price) {
        super(ticker, price);
        this.priceHistory.add(price);
    }

    public void addStockListener(StockListener listener, double min, double max) {
        this.min.put(listener, min);
        this.max.put(listener, max);
    }

    public void addStockListener(StockListener listener, double difference) {
        this.min.put(listener, this.getPrice() - difference);
        this.max.put(listener, this.getPrice() + difference);
        this.isDifferencePendent = true;
    }
    
    public void setPrice(double price) {
        if (isDifferencePendent) {
            for (StockListener i : this.min.keySet()) {
                if (price < this.min.get(i)) {
                    List<Double> prices = this.getPriceHistory();
                    i.stockPriceChanged(this, prices.get(0), price);
                }
            }
            for (StockListener i : this.max.keySet()) {
                if(price > this.max.get(i)) {
                    List<Double> prices = this.getPriceHistory();
                    i.stockPriceChanged(this, prices.get(0), price);
                }
            }
            super.setPrice(price);
        } else {
            for (StockListener i : this.min.keySet()) {
                if (price < this.min.get(i)) {
                    i.stockPriceChanged(this, this.getPrice(), price);
                }
            }
            for (StockListener i : this.max.keySet()) {
                if(price > this.max.get(i)) {
                    i.stockPriceChanged(this, this.getPrice(), price);
                }
            }
    
            super.setPrice(price);
            this.priceHistory.add(price);
        
        }
        }

    public List<Double> getPriceHistory() {
        return this.priceHistory;
    }
}
