package map.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ex2 {

    public static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        map = createMap();
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            System.out.println("word " + entry.getKey() + " --> appeared " + entry.getValue() + " times");
        }

    }

    public static Map<String, Integer> createMap() {
        String text = "public class Collections extends Object" +
                "This class consists exclusively of static methods that operate on or return collections. " +
                "It contains polymorphic algorithms that operate on collections, \"wrappers\", " +
                "which return a new collection backed by a specified collection, and a few other odds and ends." +
                "The methods of this class all throw a NullPointerException if the collections or class objects provided to them are null." +
                "The documentation for the polymorphic algorithms contained in this class generally includes a brief description of the implementation. " +
                "Such descriptions should be regarded as implementation notes, rather than parts of the specification. " +
                "Implementors should feel free to substitute other algorithms, so long as the specification itself is adhered to. " +
                "(For example, the algorithm used by sort does not have to be a mergesort, but it does have to be stable.)";
        List<String> words = Arrays.asList(text.split("[ ,.;:?!]+"));
        map = new HashMap<>();
        for(String word:words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        return map;
    }
}
