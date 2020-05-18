package map.hashmap;

import java.util.HashMap;
import java.util.Map;

public class Ex1 {

    public static void main(String[] args) {

        Map<Integer, Integer> map = new HashMap<>(20);
        for(int i=1;i<=10;i++){
            map.put(i, i*i);
        }
        System.out.println(map.get(4));

        System.out.println(map.remove(5));

        System.out.println(map.remove(2,2));

        System.out.println(map);

        System.out.println(map.putIfAbsent(2,2));
        System.out.println(map);

        System.out.println(map.getOrDefault(5,5555));
        System.out.println(map.getOrDefault(9,9999));
    }
}
