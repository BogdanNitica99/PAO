package services;

import car.Car;
import client.Client;

public class Review {

    //private Car car;
    private int carId;
    //private Client client;
    private int clientId;
    private int stars;
    private String feedback;

    public Review(int carId, int clientId, int stars, String feedback) {
        if(stars < 0 || stars > 5) {
            throw new RuntimeException("The number of stars must be in [0,5]!");
        }
        this.carId = carId;
        this.clientId = clientId;
        this.stars = stars;
        this.feedback = feedback;
    }

    public int getCarId() {
        return carId;
    }

    public int getClientId() {
        return clientId;
    }

    public int getStars() {
        return stars;
    }

    public String getFeedback() {
        return feedback;
    }
}
