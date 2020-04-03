package Products;

public class Electronic {

    private String name;
    private String fabricationDate;
    private int cost;
    private int numberOfReviews;
    private float review;

    public Electronic(String name, String fabricationDate, int cost) {
        this.name = name;
        this.fabricationDate = fabricationDate;
        this.cost = cost;
        this.numberOfReviews = 0;
        this.review = 0f;
    }

    public void giveReview(float customerReview) {
        review += customerReview;
        numberOfReviews += 1;
        review = review / numberOfReviews;
    }

    @Override
    public String toString() {
        return "Electronic{" +
                "name='" + name + '\'' +
                ", fabricationDate='" + fabricationDate + '\'' +
                ", cost=" + cost +
                ", numberOfReviews=" + numberOfReviews +
                ", review=" + review +
                '}';
    }
}
