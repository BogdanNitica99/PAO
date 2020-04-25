package client;

public abstract class Client {

    private String name;
    private int money;
    private int nrOfCars;

    public Client(String name, int money, int nrOfCars) {
        this.name = name;
        this.money = money;
        this.nrOfCars = nrOfCars;
    }

    public int getNrOfCars() {
        return nrOfCars;
    }

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public abstract int getDiscount();

    @Override
    public String toString() {
        return "client{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }
}
