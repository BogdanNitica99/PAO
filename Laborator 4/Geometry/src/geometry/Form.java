package geometry;

public abstract class Form {

    private String color;

    public Form() {
        color = "white";
    }

    public Form(String color) {
        this.color = color;
    }

    public float getArea() {
        return 0;
    }

    public String getColor() {
        return color;
    }

    public abstract void printDimension();

    @Override
    public String toString() {
        return "color: " + color + ", area: " + getArea();
    }
}


