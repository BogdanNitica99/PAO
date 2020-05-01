package exceptions.ex3;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Test2 {

    public static void main(String[] args) {

        int a, b;
        try {
            createFile();
            Scanner scanner = new Scanner(new File("test.txt"));
            a = scanner.nextInt();
            b = scanner.nextInt();
            double result = a / b;
            System.out.println(result);
            scanner.close();
            // when using multicatch, exceptions must be disjoint (not part of the same exception hierarchy)
        } catch (Exception e) {
            System.out.println(e);
            // cannot reassign a value to variable in multicatch - it it effectively final
//            e = new NoSuchElementException();
        } finally {
            System.out.println("finally");
            b = 0;
        }
    }

    static void createFile() throws IOException {
        File file = new File("test.txt");
        if (file.createNewFile()) {
            System.out.println("javaio.file created");
        } else {
            System.out.println("javaio.file already exists");
        }
//        throw new IOException("io exception while creating javaio.file");
    }
}
