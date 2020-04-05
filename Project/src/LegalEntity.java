public class LegalEntity extends Client {

    private String companyName;
    private int discount;

    public LegalEntity(String name, int money, int nrOfCars, String companyName) {
        super(name, money, nrOfCars);
        this.companyName = companyName;
    }

    @Override
    public int getDiscount() {
        int nrOfCars = getNrOfCars();
        if(nrOfCars > 10){
            this.discount = 10;
        }
        else if(nrOfCars > 20){
            this.discount = 15;
        }
        else {
            this.discount = 0;
        }
        return this.discount;
    }
}
