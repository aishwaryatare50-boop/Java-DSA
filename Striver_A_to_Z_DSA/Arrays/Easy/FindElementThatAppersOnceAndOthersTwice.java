package Striver_A_to_Z_DSA.Arrays.Easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FindElementThatAppersOnceAndOthersTwice {

    // brute approach
    // Time Complexity = O(N^2)
    // Space Complexity = O(1)
    public static int linearSearch(int[] arr, int target) {
        int count = 0;
        for(int n : arr) {
            if(n == target) {
                count++;
            }
        }

        return count;
    }

    public static int bruteApproach(int[] arr) {
        for(int n : arr) {
            if(linearSearch(arr, n) == 1) {
                return n;
            }
        }

        return -1;
    }

    // better approach
    // Time Complexity = O(N) + O(N) + O(N)
    // Space Complexity = O(N)
    public static int betterApproach(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i <arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            if(e.getValue() == 1) {
                return e.getKey();
            }
        }

        return -1;
    }

    // optimal approach
    // Time Complexity = O(N)
    // Space Complexity = O(1)
    public static int optimalApproach(int[] arr) {
        int xor = 0;
        for(int i=0; i<arr.length; i++) {
            xor = xor ^ arr[i];
        }
        return xor;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array : ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }

        // brute approach
        System.out.println("Element that appears once in given array is: " + bruteApproach(arr) + ".");

        // better approach
        System.out.println("Element that appears once in given array is: " + betterApproach(arr) + ".");

        // optimal approach
        System.out.println("Element that appears once in given array is: " + optimalApproach(arr) + ".");

        sc.close();
    }
}