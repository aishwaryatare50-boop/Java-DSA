package Striver_A_to_Z_DSA.Basics.BasicHashing;

import java.util.Scanner;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;

public class CountFrequencies {
    static Scanner sc = new Scanner(System.in);

    public static int[] createArray() {
        System.out.print("Enter size of array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = createArray();
        HashMap<Integer, Integer> map = new HashMap<>();

        // for(int i=0; i<arr.length; i++) {
        //     if(map.containsKey(arr[i])) {
        //         map.put(arr[i], map.get(arr[i]) + 1);
        //     } else {
        //         map.put(arr[i], 1);
        //     }
        // }

        // we can also use

        for(int i=0; i<arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }

        // we can also use
        Set<Integer> set = map.keySet();
        for(int val : set) {
            System.out.println(val + " -> " + map.get(val));
        }
    }
}