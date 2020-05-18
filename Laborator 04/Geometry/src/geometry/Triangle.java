package geometry;

import java.util.Objects;

public class Triangle extends Form {

    private float height;
    private float base;

    public Triangle() {
        this.height = 0f;
        this.base = 0f;
    }

    public Triangle(String color, float height, float base) {
        super(color);
        this.height = height;
        this.base = base;
    }

    public void printTriangleDimensions() {
        System.out.println("height= " + this.height + " base= " + this.base);
    }

    @Override
    public void printDimension() {
        printTriangleDimensions();
    }

    @Override
    public float getArea() {
        return base * height;
    }

    @Override
    public String toString() {
        return "Triangle: " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        //Two triangles are equals if they have the same height, base and color
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Float.compare(triangle.height, height) == 0 &&
                Float.compare(triangle.base, base) == 0 &&
                triangle.getColor().equals(getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, base);
    }
}
