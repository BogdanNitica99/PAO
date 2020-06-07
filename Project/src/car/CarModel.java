package car;

import java.util.Objects;

public class CarModel {

    private int carModelId;
    private String name;
    private String model;
    private String type;

    public CarModel(int carModelId, String name, String model, String type) {
        this.carModelId = carModelId;
        this.name = name;
        this.model = model;
        this.type = type;
    }

    public int getCarModelId() {return  carModelId;}

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarModel carModel = (CarModel) o;
        return name.equals(carModel.name) &&
                model.equals(carModel.model) &&
                type.equals(carModel.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, model, type);
    }

    @Override
    public String toString() {
        return "car.CarModel{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public String writeToCSV() {
        return name + ' ' + model + ' ' + type;
    }
}
