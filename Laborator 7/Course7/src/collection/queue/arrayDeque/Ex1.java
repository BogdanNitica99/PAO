package collection.queue.arrayDeque;

import java.util.ArrayDeque;

public class Ex1 {

    public static void main(String[] args) {

        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        arrayDeque.add("a");
        arrayDeque.addFirst("ff");

        arrayDeque.push("44");
        arrayDeque.offer("55");
        System.out.println(arrayDeque.poll());
        System.out.println(arrayDeque);
    }
}
