package car;

import java.util.Objects;

public class Car implements Comparable<Car>{

    private int carId;
    private int modelId;
    private int cost;
    private int horsepower;
    private String color;

    public Car(int carId, int modelId, int cost, int horsepower, String color) {
        this.carId = carId;
        this.modelId = modelId;
        this.cost = cost;
        this.horsepower = horsepower;
        this.color = color;
    }

    public int getCarId() {return carId;}

    public int getModelId() {
        return modelId;
    }

    public int getCost() {
        return cost;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public String getColor() {
        return color;
    }

    @Override
    public int compareTo(Car o) {
        if(this.cost != o.getCost()){
            return this.cost - o.getCost();
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return cost == car.cost &&
                horsepower == car.horsepower &&
                modelId == car.modelId &&
                color.equals(car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modelId, cost, horsepower, color);
    }

    @Override
    public String toString() {
        return "Car{" +
                "model=" + modelId +
                ", cost=" + cost +
                ", horsepower=" + horsepower +
                ", color='" + color + '\'' +
                '}';
    }

    public String writeToCSV() {
        return modelId + ' ' + horsepower + ' ' + color;
    }
}
