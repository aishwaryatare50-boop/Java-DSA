package Striver_A_to_Z_DSA.Basics.BasicHashing;

// Given an array of size N. Find the highest and lowest frequency element.

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class MaxAndMinFreqElement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array : ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int maxFreq = 0, minFreq = Integer.MAX_VALUE;
        int maxFreqElement = arr[0], minFreqElement = arr[0];

        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            if(e.getValue() > maxFreq) {
                maxFreq = e.getValue();
                maxFreqElement = e.getKey();
            } else if(e.getValue() < minFreq) {
                minFreq = e.getValue();
                minFreqElement = e.getKey();
            }
        }

        System.out.println("Maximum frequency element is " + maxFreqElement + " with frequency " + maxFreq + ".\nMinimum frequency element is " + minFreqElement + " with frequency " + minFreq + ".");


        sc.close();
    }
}