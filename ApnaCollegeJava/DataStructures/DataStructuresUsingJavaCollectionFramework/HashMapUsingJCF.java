package DataStructures.DataStructuresUsingJavaCollectionFramework;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapUsingJCF {
    public static void main(String[] args) {
        // country(key), population(value)
        HashMap<String, Integer> map = new HashMap<>();

        // Insertion
        map.put("India", 120);
        map.put("US", 30);
        map.put("China", 150);

        System.out.println(map);

        map.put("China", 180);
        System.out.println(map);

        // Search
        if(map.containsKey("China")) {
            System.out.println("China is present in the map");
        } else {
            System.out.println("China is not present in the map");
        }

        if(map.containsValue(180)) {
            System.out.println("Value exists in map");
        }

        System.out.println(map.get("China")); // key exists
        System.out.println(map.get("Indonesia")); // key doesn't exists

        // Iterator in HashMap

        int[] arr = {12, 15, 18};

        // 1st type of for loop
        for(int i=0; i<3; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // 2nd type of for loop
        for(int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();

        // Iteration in HashMap
        for(Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.print(e.getKey() + " : ");
            System.out.print(e.getValue());
            System.out.println();
        }

        Set<String> keys = map.keySet();
        for(String key : keys) {
            System.out.print(key + " : " + map.get(key));
            System.out.println();
        }

        // Remove
        // it removes both key and value
        map.remove("China");
        System.out.println(map);

        // it removes only if key and value match
        map.remove("India", 140);
        System.out.println(map);
    }
}
