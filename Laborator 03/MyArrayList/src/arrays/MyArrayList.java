package arrays;

import java.util.Arrays;

public class MyArrayList {
    private int maxCapacity;
    private float[] array;
    private int size;

    public MyArrayList() {
        this(10);
    }

    public MyArrayList(int capacity) {
        array = new float[capacity];
        maxCapacity = capacity;
    }

    public void add(float value) {
        if(size == maxCapacity) {
            maxCapacity = maxCapacity*2;
            array = Arrays.copyOf(array, maxCapacity);
        }
        array[size] = value;
        size += 1;
    }

    public boolean contains(float value) {
        for(float elem : array) {
            if(elem == value) {
                return true;
            }
        }
        return false;
    }

    public void remove(int index) {
        if(index < 0 || index > size) {
            throw new RuntimeException("The number must be a positive integer in the range [0, size)");
        }

        if (size - 1 - index >= 0)
            System.arraycopy(array, index + 1, array, index, size - 1 - index);

        size -= 1;
    }

    public float get(int index) {
        if(index < 0 || index > size) {
            throw new RuntimeException("The number must be a positive integer in the range [0, size)");
        }
        return array[index];
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder answer = new StringBuilder();

        for(int i=0;i<size-1;i++){
            answer.append(array[i]).append(", ");
        }

        answer.append((array[size - 1]));

        return answer.toString();
    }

}
