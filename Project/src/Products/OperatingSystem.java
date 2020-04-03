package Products;

public class OperatingSystem extends Software {

    private Boolean isOpenSource;

    public OperatingSystem(String name, int version, int cost, Boolean isOpenSource) {
        super(name, version, cost);
        this.isOpenSource = isOpenSource;
    }

    @Override
    public String toString() {
        return "OperatingSystem{" +
                "isOpenSource=" + isOpenSource +
                super.toString() +
                '}';
    }
}
