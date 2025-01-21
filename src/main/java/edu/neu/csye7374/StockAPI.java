package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

abstract class Stock implements Tradable {
    protected String id;
    protected double price;
    protected String description;
    protected List<Double> bidHistory;

    public Stock(String id, double price, String description) {
        this.id = id;
        this.price = price;
        this.description = description;
        this.bidHistory = new ArrayList<>();
    }

    @Override
    public void setBid(String bid) {
        try {
            double bidValue = Double.parseDouble(bid);
            bidHistory.add(bidValue);
            this.price=bidValue;
//            price = calculateNewPrice(bidValue);
        } catch (NumberFormatException e) {
            System.out.println("Invalid bid: " + bid);
        }
    }

    protected abstract double calculateNewPrice(double bid);

    @Override
    public abstract int getMetric();

    @Override
    public String toString() {
        return String.format("Stock{name='%s', price=%.2f, description='%s'", id, price, description);
    }
}