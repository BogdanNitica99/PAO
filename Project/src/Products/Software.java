package Products;

public class Software {

    private String name;
    private int version;
    private int cost;
    private int numberOfReviews;
    private float review;

    public Software(String name, int version, int cost) {
        this.name = name;
        this.version = version;
        this.cost = cost;
        numberOfReviews = 0;
        review = 0f;
    }

    public void giveReview(float customerReview) {
        review += customerReview;
        numberOfReviews += 1;
        review = review / numberOfReviews;
    }

    @Override
    public String toString() {
        return "Software{" +
                "name='" + name + '\'' +
                ", version=" + version +
                ", cost=" + cost +
                '}';
    }
}
