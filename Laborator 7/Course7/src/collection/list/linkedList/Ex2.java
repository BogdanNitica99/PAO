package collection.list.linkedList;

import java.util.LinkedList;

public class Ex2 {

    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>();
        list.add("a");
        list.add("bb");

        // methods inherited from Queue

        // add element to tail, it calls add() underneath
        list.offer("ccc");
        System.out.println(list);

        // returns head element
        //underneath it calls getFirst from Deque, throws NoSuchElementException if list is empty
        System.out.println(list.element());

        // returns first element (head), null if list is empty
        System.out.println(list.peek());

        // removes first element (the current head)
        System.out.println(list.poll());
        System.out.println(list);

        // safe to use, returns null if list is empty
        System.out.println(new LinkedList<>().poll());
    }
}
