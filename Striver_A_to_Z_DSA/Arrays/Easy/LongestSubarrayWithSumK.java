package Striver_A_to_Z_DSA.Arrays.Easy;

import java.util.Scanner;
import java.util.HashMap;

public class LongestSubarrayWithSumK {

    // brute approach
    // Time Complexity = O(N^2)
    // Space Complexity = O(1);
    public static int bruteApproach(int[] arr, int k) {
        int maxLength = 0;
        for(int i=0; i<arr.length; i++) {
            int sum = 0;
            for(int j=i; j<arr.length; j++) {
                sum += arr[j];
                if(sum == k) {
                    int length = j - i + 1;
                    if(length > maxLength) {
                        maxLength = length;
                    }
                }
            }
        }

        return maxLength;
    }

    // better approach - for only posivite elements array
    // optimal approach - for all integers array
    // Time complexity = O(N) // and in worst case O(N^2) if linkedHashMap = O(NlogN)
    // Space complexity = O(N)
    public static int longestSubarrayWithSumK(int[] arr, int k) {
        int maxLength = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++) {
            sum += arr[i]; // x

            if(sum == k) {
                if(i + 1 > maxLength) {
                    maxLength = i + 1;
                }
            }

            if(map.containsKey(sum - k)) { // x - k
                if(i - map.get(sum - k) > maxLength) {
                    maxLength = i - map.get(sum - k); 
                }
            }

            if(!map.containsKey(sum)) map.put(sum, i);
        }

        return maxLength;
    }

    // optimal approach - if array contains only positive numbers
    // Time Complexity = O(2N)
    // Space Complexity = O(1)
    public static int optimalApproach(int[] arr, int k) {
        int maxLength = 0;
        int i = 0;
        int sum = 0;
        for(int j=0; j<arr.length; j++) {

            sum += arr[j];

            while (i <= j && sum > k) {
                sum -= arr[i];
                i++;
            }

            if(sum == k) {
                int length = j - i + 1;
                if(length > maxLength) {
                    maxLength = length;
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        for(int i=0; i<arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        // brute approach
        System.out.println("Maximum length of subarray with sum equal to " + k + " is " + bruteApproach(arr, k) + ".");

        // better (or optimal approach for all integers)
        System.out.println("Maximum length of subarray with sum equal to " + k + " is " + longestSubarrayWithSumK(arr, k) + ".");

        // optimal approach if array contains only positive integers
        System.out.println("Maximum length of subarray with sum equal to " + k + " is " + optimalApproach(arr, k) + ".");

        sc.close();
    }
}