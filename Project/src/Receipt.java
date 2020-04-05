import java.util.Arrays;

public class Receipt {

    private String releasedDate;
    private int nrReceipt;
    private int totalCost;
    private Car[] objectsBought;
    private int totalObjects;

    public Receipt(String releasedDate, int nrReceipt, int totalCost, Car[] objectsBought, int totalObjects) {
        this.releasedDate = releasedDate;
        this.nrReceipt = nrReceipt;
        this.totalCost = totalCost;
        this.objectsBought = objectsBought;
        this.totalObjects = totalObjects;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "releasedDate='" + releasedDate + '\'' +
                ", nrReceipt=" + nrReceipt +
                ", totalCost=" + totalCost +
                ", objectsBought=" + Arrays.toString(objectsBought) +
                ", totalObjects=" + totalObjects +
                '}';
    }
}
