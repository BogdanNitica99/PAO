package javaio.streams.fluxuriprimitive;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ex1 {

    private static final String BASE_PATH = "./src/javaio/file/files/";

    public static void main(String[] args) {

        try (FileReader fr = new FileReader(BASE_PATH + "file1.txt");
             FileWriter fw = new FileWriter(new File(BASE_PATH, "file2.txt"), true)) {

            int c;
            while ((c = fr.read()) != -1) {
                fw.write(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
