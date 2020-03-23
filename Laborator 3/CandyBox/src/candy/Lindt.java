package candy;

public class Lindt extends CandyBox {
    private float length, height, width;

    public Lindt() {
        super("Lindt", "Switzerland");
        length = 1;
        height = 1;
        width = 1;
    }

    public Lindt(float length, float height, float width) {
        super("Lindt", "Switzerland");
        this.length = length;
        this.height = height;
        this.width = width;
    }

    @Override
    float getVolume() {
        return length * height * width;
    }

    public void printMilkaDim() {
        System.out.println(length + " " + height + " " + width);
    }
}
