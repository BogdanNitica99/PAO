package Products;

public class Tv extends Electronic {

    private float width;
    private float height;
    private Boolean isCurved;

    public Tv(String name, String fabricationDate, int cost, float width, float height, Boolean isCurved) {
        super(name, fabricationDate, cost);
        this.width = width;
        this.height = height;
        this.isCurved = isCurved;
    }

    @Override
    public String toString() {
        return "Tv{" +
                "width=" + width +
                ", height=" + height +
                ", isCurved=" + isCurved +
                super.toString() + 
                '}';
    }
}
