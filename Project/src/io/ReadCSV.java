package io;

import java.io.*;

import car.Car;
import car.CarModel;
import client.Client;
import client.Individual;
import client.LegalEntity;

public class ReadCSV {

    private static final String BASE_PATH = "./src/io/files/";

    private static ReadCSV single_instance = null;

    public static ReadCSV getInstance() {
        if (single_instance == null)
            single_instance = new ReadCSV();
        return single_instance;
    }

    public int getNumberOfLines(String fileName) {
        int lines = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(BASE_PATH + fileName));) {
            while(reader.readLine() != null) lines++;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return lines-1;
    }

    public Client[] readClient() {
        int index = 0;

        Client[] clients = new Client[0];

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(BASE_PATH + "client.csv"));) {
            int size = getNumberOfLines("client.csv");
            clients = new Client[size];

            String headers = bufferedReader.readLine();

            String line;
            while((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("[,.:'!?]+");

                String name = words[0];
                int money = Integer.parseInt(words[1]);
                int nrOfCars = Integer.parseInt(words[2]);
                String companyName = words[3];

                Client client;
                if(companyName.equals("null")) {
                    client = new Individual(name, money, nrOfCars);
                }
                else {
                    client = new LegalEntity(name, money, nrOfCars, companyName);
                }
                clients[index] = client;
                index += 1;
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return clients;
    }

    public Car[] readCar() {
        int index = 0;
        int indexModel = 0;
        int count = 0;

        Car[] cars = new Car[0];

        CarModel[] carModels = readCarModel();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(BASE_PATH + "car.csv"));) {

            int size = getNumberOfLines("car.csv");
            cars = new Car[size];

            String headers = bufferedReader.readLine();

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("[,.:;!?]+");

                String cost = words[0];
                String horsepower = words[1];
                String color = words[2];

                Car car = new Car(carModels[indexModel], Integer.parseInt(cost), Integer.parseInt(horsepower), color);
                cars[index] = car;
                index += 1;
                count += 1;
                if(count == 3){
                    indexModel += 1;
                    count = 0;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return cars;
    }

    public CarModel[] readCarModel() {
        int index = 0;

        CarModel[] carModels = new CarModel[0];

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(BASE_PATH + "carModel.csv"));) {

            int size = getNumberOfLines("carModel.csv");
            carModels = new CarModel[size];

            String headers = bufferedReader.readLine();

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("[,.:;!?]+");

                String name = words[0];
                String model = words[1];
                String type = words[2];

                CarModel carModel = new CarModel(name, model, type);
                carModels[index] = carModel;
                index += 1;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return carModels;
    }

}
