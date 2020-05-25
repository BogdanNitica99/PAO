package basic_programs;

import java.util.Scanner;

public class IfElseStatement {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        if (number > 0) {
            System.out.println(number + " is positive");
        } else if (number < 0) {
            System.out.println(number + " is negative");
        } else {
            System.out.println(number + " is neither positive nor negative");
        }

        // Leap year

        System.out.println("Enter a year: ");
        int year = scanner.nextInt();
        scanner.close();

        if(year % 4 == 0) {
            if(year % 100 != 0){
                System.out.println(year + " is a leap year");
            }
            else{
                if(year % 400 != 0){
                    System.out.println(year + " is not a leap year");
                }
                else{
                    System.out.println(year + " is a leap year");
                }
            }
        }
        else{
            System.out.println(year + " is not a leap year");
        }
    }

}
