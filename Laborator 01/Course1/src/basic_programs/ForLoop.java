package basic_programs;

import java.util.Scanner;

public class ForLoop {

    static int reverseRecursionInt = 0;

    public static void main(String[] args) {

        int inputNo;
        int inputNo2;
        int reverseNo = 0;
        System.out.println("Input an int: ");
        Scanner scanner = new Scanner(System.in);
        inputNo = scanner.nextInt();
        inputNo2 = inputNo;
        scanner.close();

        for (; inputNo != 0; ) {  // can update value here
            reverseNo = reverseNo * 10;
            reverseNo = reverseNo + inputNo % 10;
            inputNo = inputNo / 10;
        }

        System.out.println("Reverse of specified number is: " + reverseNo);

        int aux = reverseRecursion(inputNo2);

        System.out.println("Reverse of specified number using recursion is: " + reverseRecursionInt);
    }

    public static int reverseRecursion(int number) {
        if(number != 0) {
            reverseRecursionInt = reverseRecursionInt*10 + number%10;
            reverseRecursion(number / 10);
        }
        return number;
    }

}
