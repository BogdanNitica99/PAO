package javaio.streams.fluxuriprocesare;

import java.io.*;
import java.util.Arrays;

public class Ex1 {

    private static final double[] DOUBLES = {1.1, 234.11, 33.434, 546.45, 43543_23.44};
    private static final String BASE_PATH = "./src/javaio/file/files/";

    public static void main(String[] args) {

        writeToFile();
        readFromFile();
    }

    private static void writeToFile(){
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File(BASE_PATH, "file4.txt"), false))){
            dataOutputStream.writeInt(DOUBLES.length);
            for (int i = 0; i < DOUBLES.length; i++){
                dataOutputStream.writeDouble(DOUBLES[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFromFile(){
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(new File(BASE_PATH, "file4.txt")))){
            int size = dataInputStream.readInt();
            double[] doubles = new double[size];
            for (int i = 0; i < size; i++){
                doubles[i] = dataInputStream.readDouble();
            }
            System.out.println(Arrays.toString(doubles));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
