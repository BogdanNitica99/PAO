package caesarCipher;

import java.io.*;
import java.util.ArrayList;

public class CaesarCipher {

    private static final String BASE_PATH = "./src/caesarCipher/";

    public static void main(String[] args) {

        String fileToEncrypt = "msgToEncrypt.txt";
        String fileEncrypted = "msgEncrypted.txt";
        String fileDecrypted = "msgDecrypted.txt";

        ArrayList<String> unchangedLines = readFromFile(fileToEncrypt);

        encrypt(200, unchangedLines, fileEncrypted);

        ArrayList<String> encryptedLines = readFromFile(fileEncrypted);

        decrypt(200, encryptedLines, fileDecrypted);
    }

    public static ArrayList<String> readFromFile(String fileName) {

        ArrayList<String> lines = new ArrayList<String>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(BASE_PATH + fileName));) {
            String line;
            while((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static void writeToFile(String line, String fileName) {
        try {
            File file = new File(BASE_PATH + fileName);

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

    public static void encrypt(int offset, ArrayList<String> lines, String fileEncrypted){

        offset = offset % 26;

        for (String line : lines) {

            StringBuilder encryptedString = new StringBuilder();

            for (int i = 0; i < line.length(); i++) {
                char ch;
                if (line.charAt(i) >= 'a' && line.charAt(i) <= 'z' || line.charAt(i) >= 'A' && line.charAt(i) <= 'Z') {
                    if (Character.isUpperCase(line.charAt(i))) {
                        ch = (char) (line.charAt(i) + offset);
                        if (ch > 'Z')
                            ch = (char)(ch + 'A' - 'Z' - 1);
                    } else {
                        ch = (char) (line.charAt(i) + offset);
                        if (ch > 'z')
                            ch = (char)(ch + 'a' - 'z' - 1);
                    }
                }
                else {
                    ch = line.charAt(i);
                }
                encryptedString.append(ch);
            }
            writeToFile(encryptedString.toString(), fileEncrypted);
        }
    }

    public static void decrypt(int offset, ArrayList<String> lines, String fileDecrypted){

        offset = offset % 26;

        for (String line : lines) {

            StringBuilder encryptedString = new StringBuilder();

            for (int i = 0; i < line.length(); i++) {
                char ch;
                if (line.charAt(i) >= 'a' && line.charAt(i) <= 'z' || line.charAt(i) >= 'A' && line.charAt(i) <= 'Z') {
                    if (Character.isUpperCase(line.charAt(i))) {
                        ch = (char) (line.charAt(i) - offset);
                        if(ch < 'A')
                            ch = (char) (ch - 'A' + 'Z' + 1);
                    } else {
                        ch = (char) (line.charAt(i) - offset);
                        if(ch < 'a')
                            ch = (char) (ch - 'a' + 'z' + 1);
                    }
                }
                else {
                    ch = line.charAt(i);
                }
                encryptedString.append(ch);
            }
            writeToFile(encryptedString.toString(), fileDecrypted);
        }
    }
}
