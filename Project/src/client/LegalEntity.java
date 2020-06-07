package client;

import client.Client;

public class LegalEntity extends Client {

    private String companyName;

    public LegalEntity(int id, String name, int money, int nrOfCars, String companyName) {
        super(id, name, money, nrOfCars);
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    @Override
    public int getDiscount() {
        int nrOfCars = getNrOfCars();
        if(nrOfCars > 10){
            return 10;
        }
        else if(nrOfCars > 20){
            return 15;
        }
        return 0;
    }
}
