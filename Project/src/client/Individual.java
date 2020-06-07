package client;

import client.Client;

public class Individual extends Client {

    private Boolean loyalCustomer;

    public Individual(int id, String name, int money, int nrOfCars) {
        super(id, name, money, nrOfCars);
        this.loyalCustomer = nrOfCars > 3;
    }

    @Override
    public int getDiscount() {
        if(loyalCustomer) {
            return 7;
        }
        else {
            return 0;
        }
    }
}
