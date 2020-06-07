import car.Car;
import car.CarModel;
import client.Client;
import client.Individual;
import io.DbServices;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiService {

    DbServices dbServices = new DbServices();

    public void clientGui() {

        Client[] clients = dbServices.readClient();
        String[] columnNames = {"Id","Name","Money","NoCars","Company"};

        JFrame clientWindow = new JFrame("Client Frame");
        clientWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        clientWindow.setSize(700,500);

        Object[][] data = {};

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable clientTable = new JTable(model);

        for (Client client : clients) {
            model.addRow(new Object[]{client.getId(), client.getName(), client.getMoney(), client.getNrOfCars(), "null"});
        }

        JButton addNewClientButton = new JButton("Add new Client");
        addNewClientButton.setBounds(200,200,300,30);
        clientWindow.add(addNewClientButton);
        addNewClientButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                String name = JOptionPane.showInputDialog("Name");
                String money = JOptionPane.showInputDialog("Money");
                String noCars = JOptionPane.showInputDialog("NoCars");

                Client client = new Individual(0, name, Integer.parseInt(money), Integer.parseInt(noCars));

                dbServices.createClient(client);

                model.fireTableDataChanged();
            }
        });

        JButton updateClientButton = new JButton("Update Client");
        updateClientButton.setBounds(200,250,300,30);
        clientWindow.add(updateClientButton);
        updateClientButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                String id = JOptionPane.showInputDialog("Id");
                String name = JOptionPane.showInputDialog("Name");
                String money = JOptionPane.showInputDialog("Money");
                String noCars = JOptionPane.showInputDialog("NoCars");

                dbServices.updateClient(Integer.parseInt(id),name,Integer.parseInt(money),Integer.parseInt(noCars),"null");

                model.fireTableDataChanged();
            }
        });

        JButton deleteClientButton = new JButton("Delete Client");
        deleteClientButton.setBounds(200,300,300,30);
        clientWindow.add(deleteClientButton);
        deleteClientButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                String id = JOptionPane.showInputDialog("Id");

                dbServices.deleteClient(Integer.parseInt(id));

                model.fireTableDataChanged();
            }
        });

        JScrollPane scrollPane = new JScrollPane(clientTable);
        clientWindow.getContentPane().add(scrollPane);
        clientWindow.setVisible(true);
    }

    public void carGui() {

        Car[] cars = dbServices.readCar();
        CarModel[] carModels = dbServices.readCarModel();
        String[] columnNames = {"Id","Name","Model","Type","Cost","Horsepower","Color"};

        JFrame carWindow = new JFrame("Car Frame");
        carWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        carWindow.setSize(700,500);

        Object[][] data = {};

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable carTable = new JTable(model);

        for (Car car : cars) {
            model.addRow(new Object[]{car.getCarId(),carModels[car.getModelId()-1].getName(),carModels[car.getModelId()-1].getModel(),
                    carModels[car.getModelId()-1].getType(),car.getCost(), car.getHorsepower(), car.getColor()});
        }

        JButton addNewCarButton = new JButton("Add new Car");
        addNewCarButton.setBounds(200,200,300,30);
        carWindow.add(addNewCarButton);
        addNewCarButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                String modelId = JOptionPane.showInputDialog("ModelId");
                String cost = JOptionPane.showInputDialog("Cost");
                String horsepower = JOptionPane.showInputDialog("Horsepower");
                String color = JOptionPane.showInputDialog("Color");

                Car car = new Car(0, Integer.parseInt(modelId), Integer.parseInt(cost), Integer.parseInt(horsepower), color);

                dbServices.createCar(car);

                model.fireTableDataChanged();
            }
        });

        JButton updateCarButton = new JButton("Update Car");
        updateCarButton.setBounds(200,250,300,30);
        carWindow.add(updateCarButton);
        updateCarButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                String id = JOptionPane.showInputDialog("Id");
                String modelId = JOptionPane.showInputDialog("ModelId");
                String cost = JOptionPane.showInputDialog("Cost");
                String horsepower = JOptionPane.showInputDialog("Horsepower");
                String color = JOptionPane.showInputDialog("Color");

                dbServices.updateCar(Integer.parseInt(id), Integer.parseInt(modelId), Integer.parseInt(cost), Integer.parseInt(horsepower), color);

                model.fireTableDataChanged();
            }
        });

        JButton deleteCarButton = new JButton("Delete Car");
        deleteCarButton.setBounds(200,300,300,30);
        carWindow.add(deleteCarButton);
        deleteCarButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                String id = JOptionPane.showInputDialog("Id");

                dbServices.deleteCar(Integer.parseInt(id));

                model.fireTableDataChanged();
            }
        });

        JScrollPane scrollPane = new JScrollPane(carTable);
        carWindow.getContentPane().add(scrollPane);
        carWindow.setVisible(true);
    }

}
