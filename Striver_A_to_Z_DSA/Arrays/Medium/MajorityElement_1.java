package Striver_A_to_Z_DSA.Arrays.Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Find the element in array which appears more than N/2 times.

public class MajorityElement_1 {

    // brute solution
    // Time Complexity = O(N^2)
    // Space Complexity = O(1)

    public static int count(int[] arr, int target) {
        int count = 0;
        for(int n : arr) {
            if(n == target) {
                count++;
            }
        }

        return count;
    }

    public static int bruteSolution(int[] arr) {

        for(int n : arr) {
            if(count(arr, n) > arr.length / 2) {
                return n;
            }
        }

        return Integer.MIN_VALUE;
    }

    // better solution
    // Time Complexity = O(2N)
    // Space Complexity = O(N)
    public static int betterSolution(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            if(e.getValue() > arr.length / 2) {
                return e.getKey();
            } 
        }

        return Integer.MIN_VALUE;
    }

    // optimal approach
    // Moore's Voting Algorithm
    // Time Complexity = O(N)
    // Space Complexity = O(1)
    public static int mooresVotingAlgo(int[] arr) {
        int count = 0;
        int majElement = -1;

        for(int i=0; i<arr.length; i++) {
            if(count == 0) {
                majElement = arr[i];
                count = 1;
            }
            else if(arr[i] == majElement) {
                count++;
            } else {
                count--;
            }
        }

        if(count(arr, majElement) > arr.length / 2) {
            return majElement;
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }

        // brute force solution
        System.out.println("Majority element in given array is " + bruteSolution(arr) + ".");

        // better solution
        System.out.println("Majority element in given array is " + betterSolution(arr) + ".");

        // optimal solution
        System.out.println("Majority element in given array is " + mooresVotingAlgo(arr) + ".");

        sc.close();
    }
}