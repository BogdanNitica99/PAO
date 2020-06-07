package io;

import car.Car;
import car.CarModel;
import client.Client;
import client.Individual;
import client.LegalEntity;
import services.Receipt;
import services.Review;

import java.sql.*;

public class DbServices {

    Connection connection;
    Statement statement;

    public DbServices() {

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:dealearship");
            System.out.println("Conectat la baza de date Dealership");
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public int getSizeTable(String tableName) {
        int sizeTable = 0;

        try {
            this.statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tableName);

            while (resultSet.next()) {
                sizeTable += 1;
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }

        return sizeTable;
    }

    //-------------------Client CRUD-----------------------------------------------------------------

    public void createClient(Client client) {
        try {
            PreparedStatement create = connection.prepareStatement
                    ("INSERT INTO client (Name, Money, NoCars, Company) VALUES (?, ?, ?, ?)");

            create.setString(1, client.getName());
            create.setInt(2, client.getMoney());
            create.setInt(3, client.getNrOfCars());
            create.setString(4, "null");

            create.executeUpdate();
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Create Client");
    }

    public Client[] readClient() {
        int index = 0;

        Client[] clients = new Client[0];

        try {
            int sizeTable = getSizeTable("client");

            clients = new Client[sizeTable];

            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM client");

            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                String name = resultSet.getString("Name");
                int money = resultSet.getInt("Money");
                int noCars = resultSet.getInt("NoCars");
                String companyName = resultSet.getString("Company");

                Client client;
                if(companyName.equals("null")) {
                    client = new Individual(id, name, money, noCars);
                }
                else {
                    client = new LegalEntity(id, name, money, noCars, companyName);
                }
                clients[index] = client;

                index += 1;
            }
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return clients;
    }

    public void updateClient(int id, String name, int money, int nrOfCars, String company){
        try {
            PreparedStatement update = connection.prepareStatement
                    ("UPDATE client SET name = ?, money = ?, noCars = ?, company = ? WHERE id = ?");

            update.setString(1, name);
            update.setInt(2, money);
            update.setInt(3, nrOfCars);
            update.setString(4, company);
            update.setInt(5, id);

            update.executeUpdate();
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Done Updating Client");
    }

    public void deleteClient(int id){
        try {
            PreparedStatement delete = connection.prepareStatement
                    ("DELETE FROM client WHERE id = ?");

            delete.setInt(1, id);

            delete.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Done deleting Client");
    }

    //-------------------Car Model CRUD-----------------------------------------------------------------

    public void createCarModel(CarModel carModel) {
        try {
            PreparedStatement create = connection.prepareStatement
                    ("INSERT INTO carModel (Name, Model, Type) VALUES (?, ?, ?)");

            create.setString(1, carModel.getName());
            create.setString(2, carModel.getModel());
            create.setString(3, carModel.getType());

            create.executeUpdate();
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Create Car Model");
    }

    public CarModel[] readCarModel() {
        int index = 0;

        CarModel[] carModels = new CarModel[0];

        try {
            int sizeTable = getSizeTable("carModel");

            carModels = new CarModel[sizeTable];

            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM carModel");

            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                String name = resultSet.getString("Name");
                String model = resultSet.getString("Model");
                String type = resultSet.getString("Type");

                CarModel carModel;

                carModel = new CarModel(id,name, model, type);

                carModels[index] = carModel;

                index += 1;
            }
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return carModels;
    }

    public void updateCarModel(int id, String name, String model, String type){
        try {
            PreparedStatement update = connection.prepareStatement
                    ("UPDATE carModel SET name = ?, model = ?, type = ? WHERE id = ?");

            update.setString(1, name);
            update.setString(2, model);
            update.setString(3, type);
            update.setInt(4, id);

            update.executeUpdate();
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Done Updating CarModel");
    }

    public void deleteCarModel(int id){
        try {
            PreparedStatement delete = connection.prepareStatement
                    ("DELETE FROM carModel WHERE id = ?");

            delete.setInt(1, id);

            delete.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Done deleting carModel");
    }


    //-------------------Car Model CRUD-----------------------------------------------------------------

    public void createCar(Car car) {
        try {
            PreparedStatement create = connection.prepareStatement
                    ("INSERT INTO car (modelId, cost, horsepower, color) VALUES (?, ?, ?, ?)");

            create.setInt(1, car.getModelId());
            create.setInt(2, car.getCost());
            create.setInt(3, car.getHorsepower());
            create.setString(4, car.getColor());

            create.executeUpdate();
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Create Car");
    }

    public Car[] readCar() {
        int index = 0;

        Car[] cars = new Car[0];

        try {
            int sizeTable = getSizeTable("car");

            cars = new Car[sizeTable];

            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM car");

            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                int modelId = resultSet.getInt("modelId");
                int cost = resultSet.getInt("cost");
                int horsepower = resultSet.getInt("horsepower");
                String color = resultSet.getString("color");

                Car car;

                car = new Car(id,modelId,cost,horsepower,color);

                cars[index] = car;

                index += 1;
            }
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return cars;
    }

    public void updateCar(int id, int modelId, int cost, int horsepower, String color){
        try {
            PreparedStatement update = connection.prepareStatement
                    ("UPDATE car SET modelId = ?, cost = ?, horsepower = ?, color = ? WHERE id = ?");

            update.setInt(1, modelId);
            update.setInt(2, cost);
            update.setInt(3, horsepower);
            update.setString(4, color);
            update.setInt(5, id);

            update.executeUpdate();
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Done Updating Car");
    }

    public void deleteCar(int id){
        try {
            PreparedStatement delete = connection.prepareStatement
                    ("DELETE FROM car WHERE id = ?");

            delete.setInt(1, id);

            delete.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Done deleting car");
    }

    //-------------------Review CRUD-----------------------------------------------------------------

    public void createReview(Review review) {
        try {
            PreparedStatement create = connection.prepareStatement
                    ("INSERT INTO review (carId, clientId, stars, feedback) VALUES (?, ?, ?, ?)");

            create.setInt(1, review.getCarId());
            create.setInt(2, review.getClientId());
            create.setInt(3, review.getStars());
            create.setString(4, review.getFeedback());

            create.executeUpdate();
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Create Review");
    }

    public Review[] readReview() {
        int index = 0;

        Review[] reviews = new Review[0];

        try {
            int sizeTable = getSizeTable("review");

            reviews = new Review[sizeTable];

            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM review");

            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                int carId = resultSet.getInt("carId");
                int clientId = resultSet.getInt("clientId");
                int stars = resultSet.getInt("stars");
                String feedback = resultSet.getString("feedback");

                Review review;

                review = new Review(carId,clientId,stars,feedback);

                reviews[index] = review;

                index += 1;
            }
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return reviews;
    }

    public void updateReview(int id, int carId, int clientId, int stars, String feedback){
        try {
            PreparedStatement update = connection.prepareStatement
                    ("UPDATE review SET carId = ?, clientId = ?, stars = ?, feedback = ? WHERE id = ?");

            update.setInt(1, carId);
            update.setInt(2, clientId);
            update.setInt(3, stars);
            update.setString(4, feedback);
            update.setInt(5, id);

            update.executeUpdate();
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Done Updating review");
    }

    public void deleteReview(int id){
        try {
            PreparedStatement delete = connection.prepareStatement
                    ("DELETE FROM review WHERE id = ?");

            delete.setInt(1, id);

            delete.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Done deleting review");
    }

    //-------------------Receipt CRUD-----------------------------------------------------------------

    public void createReceipt(Receipt receipt) {
        try {
            PreparedStatement create = connection.prepareStatement
                    ("INSERT INTO receipt (cost, noCars, date, clientId, discount) VALUES (?, ?, ?, ?, ?)");

            create.setInt(1, receipt.getTotalCost());
            create.setInt(2, receipt.getTotalObjects());
            create.setString(3, receipt.getDate());
            create.setInt(4, receipt.getClientId());
            create.setInt(5, receipt.getDiscount());

            create.executeUpdate();
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Create receipt");
    }

    public Review[] readReceipt() {
        int index = 0;

        Review[] reviews = new Review[0];

        try {
            int sizeTable = getSizeTable("receipt");

            reviews = new Review[sizeTable];

            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM receipt");

            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                int carId = resultSet.getInt("carId");
                int clientId = resultSet.getInt("clientId");
                int stars = resultSet.getInt("stars");
                String feedback = resultSet.getString("feedback");

                Review review;

                review = new Review(carId,clientId,stars,feedback);

                reviews[index] = review;

                index += 1;
            }
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return reviews;
    }

    public void updateReceipt(int cost, int noCars, String date, int clientId, int discount){
        try {
            PreparedStatement update = connection.prepareStatement
                    ("UPDATE receipt SET cost = ?, noCars = ?, date = ?, clientId = ?, discount = ? WHERE id = ?");

            update.setInt(1, cost);
            update.setInt(2, noCars);
            update.setString(3, date);
            update.setInt(4, clientId);
            update.setInt(5, discount);

            update.executeUpdate();
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Done Updating receipt");
    }

    public void deleteReceipt(int id){
        try {
            PreparedStatement delete = connection.prepareStatement
                    ("DELETE FROM receipt WHERE id = ?");

            delete.setInt(1, id);

            delete.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Done deleting receipt");
    }

}
