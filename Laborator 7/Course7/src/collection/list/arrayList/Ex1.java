package collection.list.arrayList;

import java.util.ArrayList;
import java.util.List;

public class Ex1 {

    public static void main(String[] args) {

        // without generics
        List bulkList = new ArrayList();
        bulkList.add(1);
        bulkList.add("another element");
        bulkList.add(new Object());
        System.out.println(bulkList);

        // no args constructor
        List<String> list1 = new ArrayList<>(); // implicit size = 10
        // isEmpty is defined in List interface
        System.out.println(list1.isEmpty());
        // add at the end
        list1.add("1");
        list1.add("2");
        // add at a particular index
        list1.add(0, "3");
        // index must be <= current size
        list1.add(3, "5");
        // size inherited from Collection
        System.out.printf("size is %d", list1.size());
        System.out.println();

        if (list1.contains("2")) {
            // pay attention to overloaded method
            System.out.println(list1.remove(1)); // returns the element at specified index
            System.out.println(list1.remove("2")); // returns boolean
        }
        System.out.println(list1); // overrides toString

        //constructor accepting another collection
        List<String> list2 = new ArrayList<>(list1);
        System.out.println(list2);

        // add the content of another collection at the end
        list2.addAll(list1);
        System.out.println("list2: " + list2);

        // add the content of another collection starting at a specific index
        list2.addAll(1, list1);
        System.out.println(list2);

        // removes from list2 all the values also found in list1
        list2.removeAll(list1);
        System.out.println("list2 after removeAll: " + list2);

        // clears all the content, returns void
        list1.clear();
        System.out.println("list1 after clear: " + list1);
    }
}
