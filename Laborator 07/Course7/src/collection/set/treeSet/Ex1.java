package collection.set.treeSet;

import collection.set.Person;
import collection.set.PersonComparator;

import java.util.Arrays;
import java.util.TreeSet;

public class Ex1 {

    public static void main(String[] args) {

        TreeSet<Integer> set1 = new TreeSet<>(Arrays.asList(55, 33, 1, 766, 8, 99));
        System.out.println(set1); // prints elements in natural order

        TreeSet<Person> set2 = new TreeSet<>(new PersonComparator());
        set2.add(new Person("Mircea M", 33));
        set2.add(new Person("Adrian S", 30));
        set2.add(new Person("Maria B", 28));
        System.out.println(set2);
    }
}
