package Striver_A_to_Z_DSA.Arrays.Hard;

import java.util.Scanner;
import java.util.HashMap;

public class NumberOfSubarraysWithXORasK {

    // brute solution 
    // Time Complexity = O(N^2) // O(N^3) if we used a loop for xor of ith to jth element
    // Space Complexity = O(1)
    public static int bruteSolution(int[] arr, int k) {
        int count = 0;

        for(int i=0; i<arr.length; i++) {
            int xor = 0;
            for(int j=i; j<arr.length; j++) {
                xor = xor ^ arr[j];
                if(xor == k) {
                    count++;
                }
            }
        }

        return count;
    }

    // optimal solution
    // Time Complexity = O(N)
    // Space Complexity = O(N)
    public static int optimalSolution(int[] arr, int k) {
        // x ^ k = XR
        // (x ^ k) ^ k = XR ^ k
        // x = XR ^ K
        int count = 0;
        int XR = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        for(int i=0; i<arr.length; i++) {
            XR = XR ^ arr[i];
            int x = XR ^ k;
            
            count += map.getOrDefault(x, 0);

            map.put(XR, map.getOrDefault(XR, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        // brute solution
        System.out.println("Subarrays with XOR as " + k + " are: " + bruteSolution(arr, k) + ".");

        // optimal solution
        System.out.println("Subarrays with XOR as " + k + " are: " + optimalSolution(arr, k) + ".");

        sc.close();
    }
}