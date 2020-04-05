public class Client {

    private String name;
    private int money;
    private int nrOfCars;
    private int discount;

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

    public int getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                '}';
    }
}
