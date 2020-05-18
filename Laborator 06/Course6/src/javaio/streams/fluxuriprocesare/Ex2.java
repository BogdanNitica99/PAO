package javaio.streams.fluxuriprocesare;

import java.io.*;
import java.util.Arrays;

public class Ex2 {
    private static final String BASE_PATH = "./src/javaio/file/files/";

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(BASE_PATH + "file1.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter((new FileWriter(new File(BASE_PATH, "file5.txt"))))) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("[ ,.:;!?]+");
                Arrays.sort(words);
                System.out.println(Arrays.toString(words));
                for (String s : words) {
                    bufferedWriter.write(s);
                    bufferedWriter.write("\n");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
