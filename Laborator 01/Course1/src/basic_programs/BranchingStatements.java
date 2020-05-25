package basic_programs;

import java.util.Scanner;

public class BranchingStatements {

    public static void main(String[] args) {

        int preSetValue = 0;
        int number;

        System.out.println("Input an int: ");
        Scanner scanner = new Scanner(System.in);
        number = scanner.nextInt();

        while(number != preSetValue) {
            System.out.println("Input an int: ");
            number = scanner.nextInt();
        }

    }

}
