package map.treemap;

import map.hashmap.Ex2;

import java.util.TreeMap;

public class Ex1 {

    public static void main(String[] args) {

        TreeMap<String, Integer> treeMap = new TreeMap<>(Ex2.createMap());

        System.out.println(treeMap);
    }
}
