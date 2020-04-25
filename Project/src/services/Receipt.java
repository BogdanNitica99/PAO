package services;

import car.Car;
import client.Client;

import java.util.Arrays;

public class Receipt {

    private int nrReceipt;
    private int totalCost;
    private Car[] objectsBought;
    private int totalObjects;
    private Client client;
    private int discount;

    public Receipt(int nrReceipt, int totalCost, Car[] objectsBought, int totalObjects, Client client, int discount) {
        this.nrReceipt = nrReceipt;
        this.totalCost = totalCost;
        this.objectsBought = objectsBought;
        this.totalObjects = totalObjects;
        this.client = client;
        this.discount = discount;
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

    public Client getClient() {
        return client;
    }

    public int getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return "services.Receipt{" +
                ", nrReceipt=" + nrReceipt +
                ", totalCost=" + totalCost +
                ", objectsBought=" + Arrays.toString(objectsBought) +
                ", totalObjects=" + totalObjects +
                ", client=" + client.toString() +
                ", discount=" + discount +
                '}';
    }
}
