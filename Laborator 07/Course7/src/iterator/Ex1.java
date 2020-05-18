package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ex1 {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("cd");
        list.add("cde");
        list.add("ee");

        for(String s: list){
            System.out.println(s);
        }

        Iterator<String>iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //enhanced for has a fail-fast iterator
        //for (String s : list) { // throws ConcurrentModificationException
        // if (s.length() % 2 == 0) {
        //   list.remove(s);
        //  }
        //}


        //Iterator<String> iterator2 = list.iterator();
        //while (iterator2.hasNext()) {
        //	String element = iterator2.next(); // throws ConcurrentModificationException
        //	if (element.length() % 2 == 1) {
        //		list.remove(element);  // cannot call remove on list
        //	}
        //}

        Iterator<String> iterator3 = list.iterator();
        while (iterator3.hasNext()) {
            String element = iterator3.next();
            if (element.startsWith("c")) {
                iterator3.remove(); // can call remove on iterator
            }
        }
        System.out.println(list);
    }
}
