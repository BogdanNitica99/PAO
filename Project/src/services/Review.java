package services;

import car.Car;
import client.Client;

public class Review {

    private Car car;
    private Client client;
    private int stars;
    private String feedback;

    public Review(Car car, Client client, int stars, String feedback) {
        if(stars < 0 || stars > 5) {
            throw new RuntimeException("The number of stars must be in [0,5]!");
        }
        this.car = car;
        this.client = client;
        this.stars = stars;
        this.feedback = feedback;
    }

    public Car getCar() {
        return car;
    }

    public Client getClient() {
        return client;
    }

    public int getStars() {
        return stars;
    }

    public String getFeedback() {
        return feedback;
    }
}
