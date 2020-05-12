package collection.list.linkedList;

import java.util.LinkedList;

public class Ex3 {

    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.addFirst(2); // returns void
        list.addLast(3);
        list.offerFirst(33); // returns boolean
        list.offerLast(44);
        list.push(11); // adds to head, calls addFirst() underneath
        System.out.println(list);

        System.out.println(list.pop()); // returns the element removed, calls removeFirst() underneath
        System.out.println(list);
		//System.out.println(new LinkedList<>().pop()); // throws NoSuchElementException if list is empty

        System.out.println(list.getFirst()); //33
        System.out.println(list.getLast()); // 44, throws exception if list is empty
        System.out.println(list.peekFirst()); //33
        System.out.println(list.peekLast()); // 44, returns null if list is empty

        System.out.println(list.pollFirst()); // 33 and removes it
        System.out.println(list.pollLast()); //44 and removes it
        System.out.println(list);

        System.out.println(list.removeFirst()); // 2 and removes it, exception if empty list
        System.out.println(list.removeLast()); // 3 and removes it, exception if empty list
        System.out.println(list);
    }
}
