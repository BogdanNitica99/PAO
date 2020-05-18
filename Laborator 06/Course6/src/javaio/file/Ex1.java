package javaio.file;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Ex1 {

    private static final String BASE_PATH = ".src/javaio/file/files";

    public static void main(String[] args) {
        System.out.println(System.getProperty("file.separator"));
        System.out.println(File.separator);

        // create dir
        File dir1 = new File(BASE_PATH, "/dir1");
        System.out.println(dir1.mkdir());

        // create dirs
        File dir2 = new File(BASE_PATH, "/a/b/dir2");
        System.out.println(dir2.mkdirs());

        File f1 = new File(BASE_PATH, "file1.txt");
        try {
            if (f1.createNewFile()) {
                System.out.println("file created");
            } else {
                System.out.println(f1.exists());
                System.out.println("file already exists");
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        //check if javaio.file exists
        System.out.println(f1.exists());

        System.out.println(f1.getName());
        System.out.println(f1.length());
        System.out.println(f1.getAbsolutePath());

        //list files and folders
        System.out.println(Arrays.toString(new File("./src/javaio/file").listFiles()));
    }
}
