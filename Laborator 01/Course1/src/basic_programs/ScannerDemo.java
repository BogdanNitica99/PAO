package basic_programs;

import java.util.Scanner;

public class ScannerDemo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");

        String myName = scanner.nextLine();

        scanner.close();

        System.out.println("My name is: " + myName);
    }

}
