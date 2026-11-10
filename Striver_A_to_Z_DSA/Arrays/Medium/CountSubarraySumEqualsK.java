package Striver_A_to_Z_DSA.Arrays.Medium;

import java.util.Scanner;
import java.util.HashMap;

public class CountSubarraySumEqualsK {

    // brute approach
    // Time Complexity = O(N^2)
    // Space Complexity = O(1)
    public static int bruteApproach(int[] arr, int k) {
        int ans = 0;

        for(int i=0; i<arr.length; i++) {
            int sum = 0;
            for(int j=i; j<arr.length; j++) {
                sum += arr[j];
                if(sum == k) {
                    ans++;
                }
            }
        }

        return ans;
    }

    // optimal approach
    // Time Complexity = O(N)
    // Space Complexity = O(N)
    public static int optimalApproach(int[] arr, int k) {
        int ans = 0;
        int prefixSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for(int i=0; i<arr.length; i++) {
            prefixSum += arr[i];

            if(map.containsKey(prefixSum - k)) {
                ans += map.get(prefixSum - k);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter target k: ");
        int k = sc.nextInt();

        // brute solution
        System.out.println("Subarrays with sum equal to " + k + " in given array are " + bruteApproach(arr, k) +".");

        // optimal solution
        System.out.println("Subarrays with sum equal to " + k + " in given array are " + optimalApproach(arr, k) +".");

        sc.close();
    }    
}