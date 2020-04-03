package Products;

public class Phone extends Electronic {

    private int memory;
    private String batteryDuration;
    private Boolean isSmartphone;


    public Phone(String name, String fabricationDate, int cost, int memory, String batteryDuration, Boolean isSmartphone) {
        super(name, fabricationDate, cost);
        this.memory = memory;
        this.batteryDuration = batteryDuration;
        this.isSmartphone = isSmartphone;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "memory=" + memory +
                ", batteryDuration='" + batteryDuration + '\'' +
                ", isSmartphone=" + isSmartphone +
                super.toString() +
                '}';
    }
}
