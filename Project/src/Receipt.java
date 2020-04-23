import car.Car;
import client.Client;

import java.util.Arrays;

public class Receipt {

    private String releasedDate;
    private int nrReceipt;
    private int totalCost;
    private Car[] objectsBought;
    private int totalObjects;
    private Client client;
    private int discount;

    public Receipt(String releasedDate, int nrReceipt, int totalCost, Car[] objectsBought, int totalObjects, Client client, int discount) {
        this.releasedDate = releasedDate;
        this.nrReceipt = nrReceipt;
        this.totalCost = totalCost;
        this.objectsBought = objectsBought;
        this.totalObjects = totalObjects;
        this.client = client;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "releasedDate='" + releasedDate + '\'' +
                ", nrReceipt=" + nrReceipt +
                ", totalCost=" + totalCost +
                ", objectsBought=" + Arrays.toString(objectsBought) +
                ", totalObjects=" + totalObjects +
                ", client=" + client.toString() +
                ", discount=" + discount +
                '}';
    }
}
