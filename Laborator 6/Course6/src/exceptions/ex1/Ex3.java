package exceptions.ex1;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Ex3 {

    public static void main(String[] args) {
        int a,b;
        try {
            createFile();
            Scanner scanner = new Scanner(new File("test.txt"));
            a = scanner.nextInt();
            b = scanner.nextInt();

            double result = a / b;

            System.out.println(result);

            scanner.close();
        }
        catch (IOException | NoSuchElementException | ArithmeticException e) {
            System.out.println(e);
        }
    }

    static void createFile() throws IOException {
        File file = new File("test.txt");
        if(file.createNewFile()) {
            System.out.println("created file");
        }
        else {
            System.out.println("file already existed");
        }
    }
}
