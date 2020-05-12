package collection.list.linkedList;

import java.util.LinkedList;

public class Ex1 {
    public static void main(String[] args) {

        // creates an empty list
        LinkedList<String> list1 = new LinkedList<>();

        list1.add("abc");
        list1.add(0, "aaa");
        // methods specific to LinkedList, inherited from Deque
        list1.addFirst("rrr");
        list1.addLast("123");
        System.out.println(list1);
        list1.removeFirst();
        list1.removeLast();
        System.out.println(list1);

        list1.addAll(list1);
        System.out.println(list1);
        list1.removeFirstOccurrence("aaa");
        System.out.println(list1);

        System.out.println(list1.getFirst());
        System.out.println(list1.getLast());

    }

}
