import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LongestWord {

    private static final String BASE_PATH = "./src/";

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(BASE_PATH + "input.txt"));) {

            int maxLength = -1;
            String maxWord = "";

            String line;
            while((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("[ ,.:'!?]+");

                for (String word : words) {
                    if (word.length() > maxLength) {
                        maxLength = word.length();
                        maxWord = word;
                    }
                }
            }
            System.out.println("The longest word is: " + maxWord);
        }
        catch(IOException e) {
            e.printStackTrace();
        }

    }
}
