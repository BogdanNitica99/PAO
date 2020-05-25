package basic_programs;

import java.util.Scanner;

public class WhileStatement {

    public static void main(String[] args) {

        int inputNo;
        int inputNo2;
        int reverseNo = 0;
        int reverseNo2 = 0;

        System.out.println("Input an int number: ");
        Scanner scanner = new Scanner(System.in);
        inputNo = scanner.nextInt();
        scanner.close();

        inputNo2 = inputNo;

        while (inputNo != 0) {
            reverseNo = reverseNo * 10;
            reverseNo = reverseNo + inputNo % 10;
            inputNo = inputNo / 10;
        }

        System.out.println("Reverse of input number is: " + reverseNo);

        if(inputNo2 != 0) {

            do{
                reverseNo2 = reverseNo2 * 10;
                reverseNo2 = reverseNo2 + inputNo2 % 10;
                inputNo2 = inputNo2 / 10;
            }
            while(inputNo2 != 0);

        }

        System.out.println("Reverse of input number is: " + reverseNo2);
    }
}
