package io;

import services.Receipt;
import services.Review;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WriteCSV {

    private static final String BASE_PATH = "./src/io/files/";

    private static WriteCSV single_instance = null;

    public static WriteCSV getInstance() {
        if (single_instance == null)
            single_instance = new WriteCSV();
        return single_instance;
    }

    public void writeReview(Review review) {
        try {
            File file = new File(BASE_PATH + "review.csv");

            if (!file.exists()) {
                file.createNewFile();
                FileWriter fw = new FileWriter(file, true);
                fw.append("CarName,Stars,Client,Feedback\n");
            }

            FileWriter fw = new FileWriter(file, true);

            String car = review.getCar().writeToCSV();
            String client = review.getClient().getName();
            String stars = Integer.toString(review.getStars());
            String feedback = review.getFeedback();

            fw.append(car);
            fw.append(",");
            fw.append(stars);
            fw.append(",");
            fw.append(client);
            fw.append(",");
            fw.append(feedback);
            fw.append('\n');
            fw.flush();
            fw.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

    public void writeReceipt(Receipt receipt) {
        try {
            File file = new File(BASE_PATH + "receipt.csv");

            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

            if (!file.exists()) {
                file.createNewFile();
                FileWriter fw = new FileWriter(file, true);
                fw.append("Id,Cost,NoCars,Cars,Date,Client,Discount\n");
            }

            FileWriter fw = new FileWriter(file, true);

            String nrReceipt = Integer.toString(receipt.getNrReceipt());
            fw.append(nrReceipt);
            fw.append(",");

            String totalCost = Integer.toString(receipt.getTotalCost());
            fw.append(totalCost);
            fw.append(",");

            String totalCars = Integer.toString(receipt.getTotalObjects());
            fw.append(totalCars);
            fw.append(",");

            for (int i = 0; i < receipt.getTotalObjects(); i++) {
                String car = receipt.getObjectsBought()[i].writeToCSV();
                fw.append(car);
                if(i == receipt.getTotalObjects() - 1) {
                    fw.append(",");
                }
                else {
                    fw.append(" and ");
                }
            }

            Date date = new Date();
            fw.append(dateFormat.format(date));
            fw.append(",");

            String client = receipt.getClient().getName();
            fw.append(client);
            fw.append(",");

            String discount = Integer.toString(receipt.getDiscount());
            fw.append(discount);

            fw.append('\n');
            fw.flush();
            fw.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

}
