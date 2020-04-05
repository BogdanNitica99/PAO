public class Review {

    private Car car;
    private String nameUser;
    private int stars;
    private String feedback;

    public Review(Car car, String nameUser, int stars, String feedback) {
        if(stars < 0 || stars > 5) {
            throw new RuntimeException("The number of stars must be in [0,5]!");
        }
        this.car = car;
        this.nameUser = nameUser;
        this.stars = stars;
        this.feedback = feedback;
    }
}
