package arrays;

import java.util.Scanner;

public class Ex4 {

    public static void main(String[] args) {

        // only first dimension is required when creating a multidimensional array
        int[][] array = new int[4][];
        // each element holds a reference to another single-dimensional array (of different sizes)
        // first row has 2 columns
        array[0] = new int[2]; // only declaration and instantiation
        // second row has 1 column
        array[1] = new int[1];
        // third row has 3 columns
        array[2] = new int[]{0, 1, 2}; // inline initialization after instantiation
        // fourth row has 5 columns
        array[3] = new int[5];

        // initialization of array[3]
        array[3][0] = 30;
        array[3][1] = 31;
        array[3][2] = 32;
        array[3][3] = 33;
        array[3][4] = 34;

        printMultidimensionalIntArray(array);

//        * TO DO: write a program to create a 2D-array, with both dimensions and elements input by user

        int dim1, dim2, aux;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Input the number of rows: ");
        dim1 = scanner.nextInt();

        System.out.println("Input the number of columns: ");
        dim2 = scanner.nextInt();

        int[][] userInputArray = new int[dim1][dim2];

        for(int i=0;i<userInputArray.length;i++){
            for(int j=0;j<userInputArray[i].length;j++){
                System.out.println("Input the number for the " + i + " row and " + j + " column: ");
                aux = scanner.nextInt();
                userInputArray[i][j] = aux;
            }
        }

        scanner.close();
        System.out.println("---------------------------");
        printMultidimensionalIntArray(userInputArray);
    }

    private static void printMultidimensionalIntArray(int[][] arrayToPrint) {
        for (int[] row : arrayToPrint) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

}
