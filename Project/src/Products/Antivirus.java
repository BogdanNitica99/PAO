package Products;

public class Antivirus extends Software{

    private int howManyDevices; // on how many devices can a user activate din product
    private Boolean worksOnPhones;

    public Antivirus(String name, int version, int cost, int howManyDevices, Boolean worksOnPhones) {
        super(name, version, cost);
        this.howManyDevices = howManyDevices;
        this.worksOnPhones = worksOnPhones;
    }

    @Override
    public String toString() {
        return "Antivirus{" +
                "howManyDevices=" + howManyDevices +
                ", worksOnPhones=" + worksOnPhones +
                super.toString() +
                '}';
    }
}
