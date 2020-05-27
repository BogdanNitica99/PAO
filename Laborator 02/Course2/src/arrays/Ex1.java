package arrays;

public class Ex1 {

    public static void main(String[] args) {

        int[] intArray;

        // instantiate the array using new operator (allocate memory for 5 integers)
        intArray = new int[5];
        // initialize some elements
        intArray[0] = 123;
        intArray[2] = 11;
        intArray[4] = 0;
        //intArray[5] = 55; // this line will compile, but will throw an exception at runtime

        // display all the values
        for (int i = 0; i < intArray.length; i++) { // length is a built-in property of arrays
            System.out.println("Element at index " + i + ": " + intArray[i]);
        }

        // can also put the brackets after the name, but language convention discourages this form
        int anotherIntArray[] = new int[10];

        // can declare an array of any other primitive or reference type
        byte[] byteArray;
        short[] shortArray;
        long[] longArray;
        float[] floatArray;
        double[] doubleArray;
        char[] charArray;
        boolean[] booleanArray;
        String[] stringArray = args;
        Object[] objectArray;
    }

}
