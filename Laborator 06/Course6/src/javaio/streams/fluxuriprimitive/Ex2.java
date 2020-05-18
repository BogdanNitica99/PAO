package javaio.streams.fluxuriprimitive;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex2 {

    private static final String BASE_PATH = "./src/javaio/file/files/";

    public static void main(String[] args) {

        try (FileInputStream fis = new FileInputStream(BASE_PATH + "file1.txt");
             FileOutputStream fos = new FileOutputStream(new File(BASE_PATH, "file3.txt"))) {

            // returneaza nr de octeti din fisier
            int size = fis.available();
            byte[] buffer = new byte[size];
            fis.read(buffer);
            fos.write(buffer);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
