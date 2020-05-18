package arrays;

import java.util.Random;

public class MyArrayListTest {

    public static void main(String[] args) {

        MyArrayList array = new MyArrayList(3);

        array.add(3.2f);
        array.add(1.42f);
        array.add(5.0f);

        if(array.get(0) == 3.2f && array.get(1) == 1.42f && array.get(2) == 5.0f) {
            System.out.println("The values are correct");
        }

        int test_capacity = 5;

        Random rand = new Random();

        MyArrayList use_array = new MyArrayList(test_capacity);

        for(int i=0;i<test_capacity*2;i++) {
            use_array.add(rand.nextFloat());
        }

        System.out.println("Initial array : " + use_array);

        for(int i=0;i<test_capacity;i++) {
            float val = rand.nextFloat();
            if (use_array.contains(val)) {
                System.out.println("Contine acesta valoare " + val);
            }
            else {
                System.out.println("Nu contine acesta valoare " + val);
            }
        }

        for(int i=0;i<test_capacity;i++) {
            use_array.remove(rand.nextInt(test_capacity-1));
        }

        System.out.println("Final array : " + use_array);
    }
}
