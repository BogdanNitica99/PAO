package Products;

public class Laptop extends Electronic {

    private String operatingSystem;
    private int memory;

    public Laptop(String name, String fabricationDate, int cost, String operatingSystem, int memory) {
        super(name, fabricationDate, cost);
        this.operatingSystem = operatingSystem;
        this.memory = memory;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "operatingSystem='" + operatingSystem + '\'' +
                ", memory=" + memory +
                super.toString() +
                '}';
    }
}
