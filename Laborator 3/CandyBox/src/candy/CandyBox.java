package candy;

public class CandyBox {
    private String flavour;
    private String origin;

    public CandyBox() {

    }

    public CandyBox(String flavour, String origin) {
        this.flavour = flavour;
        this.origin = origin;
    }

    float getVolume() {
        return 0;
    }

    @Override
    public String toString() {
        return "The " + origin + " " + flavour + " has volume " + getVolume();
    }

    @Override
    public boolean equals(Object obj) {
        // Check if the object is compared with itself
        if (obj == this)
            return true;

        // typecast obj to CandyBox so we can compare values
        CandyBox candy = (CandyBox) obj;

        return flavour.equals(candy.flavour);
    }
}
