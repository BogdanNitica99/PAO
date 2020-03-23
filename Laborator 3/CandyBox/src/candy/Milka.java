package candy;

public class Milka extends CandyBox {
    private float height, radius;

    public Milka() {
        super("Milka","Deutschalnd");
        height = 1;
        radius = 1;
    }

    public Milka(float height, float radius) {
        super("Milka","Deutschland");
        this.height = height;
        this.radius = radius;
    }

    @Override
    float getVolume() {
        return height * (float)Math.PI * (radius * radius);
    }

    public void printMilkaDim() {
        System.out.println(height + " " + radius);
    }
}
