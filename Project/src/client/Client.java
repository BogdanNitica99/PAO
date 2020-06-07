package client;

public abstract class Client {

    private int id;
    private String name;
    private int money;
    private int nrOfCars;

    public Client(int id, String name, int money, int nrOfCars) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.nrOfCars = nrOfCars;
    }

    public int getId() {return id;}

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
