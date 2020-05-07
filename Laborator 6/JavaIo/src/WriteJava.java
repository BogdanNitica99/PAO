import java.io.*;

public class WriteJava {

    private static final String BASE_PATH = "./src/";

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(BASE_PATH + "LongestWord.java"));) {

            String line;
            while((line = bufferedReader.readLine()) != null) {
                writeToFile(line);
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile(String line) {
        try {
            File file = new File(BASE_PATH + "input.txt");

            if (!file.exists()) {
                file.createNewFile();
                FileWriter fw = new FileWriter(file, true);
            }

            FileWriter fw = new FileWriter(file, true);

            fw.append(line);
            fw.append("\n");

            fw.flush();
            fw.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}
