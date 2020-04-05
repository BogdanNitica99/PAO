import java.util.Objects;

public class Car {

    private CarModel model;
    private int cost;
    private int horsepower;
    private String color;

    public Car(CarModel model, int cost, int horsepower, String color) {
        this.model = model;
        this.cost = cost;
        this.horsepower = horsepower;
        this.color = color;
    }

    public int getCost() {
        return this.cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return cost == car.cost &&
                horsepower == car.horsepower &&
                model.equals(car.model) &&
                color.equals(car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, cost, horsepower, color);
    }

    @Override
    public String toString() {
        return "Car{" +
                "model=" + model.toString() +
                ", cost=" + cost +
                ", horsepower=" + horsepower +
                ", color='" + color + '\'' +
                '}';
    }
}
