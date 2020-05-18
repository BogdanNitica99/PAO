package candy;

public class Heidi extends CandyBox {
    private float length;

    public Heidi() {
        //De ce initializez cu Super
        super("Heidi", "Switzerland");
        this.length = 1;
    }

    public Heidi(float length) {
        super("Heidi", "Switzerland");
        this.length = length;
    }

    @Override
    float getVolume() {
        return length * length * length;
    }

    public void printMilkaDim() {
        System.out.println(length);
    }
}
