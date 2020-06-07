package services;

import car.Car;
import client.Client;

import java.util.Arrays;

public class Receipt {

    private int nrReceipt;
    private int totalCost;
    private Car[] objectsBought;
    private int totalObjects;
    private int clientId;
    private int discount;
    private String date;

    public Receipt(int nrReceipt, int totalCost, Car[] objectsBought, int totalObjects, int clientId, int discount, String date) {
        this.nrReceipt = nrReceipt;
        this.totalCost = totalCost;
        this.objectsBought = objectsBought;
        this.totalObjects = totalObjects;
        this.clientId = clientId;
        this.discount = discount;
        this.date = date;
    }

    public int getNrReceipt() {
        return nrReceipt;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public Car[] getObjectsBought() {
        return objectsBought;
    }

    public int getTotalObjects() {
        return totalObjects;
    }

    public int getClientId() {
        return clientId;
    }

    public int getDiscount() {
        return discount;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "services.Receipt{ nrReceipt=" + nrReceipt +
                ", totalCost=" + totalCost +
                ", objectsBought=" + Arrays.toString(objectsBought) +
                ", totalObjects=" + totalObjects +
                ", client=" + clientId +
                ", discount=" + discount +
                '}';
    }

    public String writeNice() {
        return nrReceipt + ", "  + totalCost + ", " + totalObjects + ", " + Arrays.toString(objectsBought) + ", " + clientId + ", " + discount;
    }
}
