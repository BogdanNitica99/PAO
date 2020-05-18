package geometry;

public class Circle extends Form {

    private float radius;

    public Circle() {
        this.radius = 0f;
    }

    public Circle(String color, float radius) {
        super(color);
        this.radius = radius;
    }

    public void printCircleDimensions() {
        System.out.println("radius= " + this.radius);
    }

    @Override
    public void printDimension() {
        printCircleDimensions();
    }

    @Override
    public float getArea() {
        return radius * radius * (float)Math.PI;
    }

    @Override
    public String toString() {
        return "Circle: " + super.toString();
    }
}
