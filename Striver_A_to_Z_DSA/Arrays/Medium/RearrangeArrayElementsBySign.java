package Striver_A_to_Z_DSA.Arrays.Medium;

import java.util.Scanner;
import java.util.ArrayList;

public class RearrangeArrayElementsBySign {

    public static void printArray(int[] arr) {
        for(int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    // brute approach
    // Time Complexity = O(N + N/2)
    // Space Complexity = O(N)
    public static void bruteApproach(int[] arr) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for(int i=0; i<arr.length; i++) {
            if(arr[i] < 0) {
                neg.add(arr[i]);
            } else {
                pos.add(arr[i]);
            }
        }

        for(int i=0; i<arr.length/2; i++) {
            arr[2 * i] = pos.removeFirst();
            arr[2 * i + 1] = neg.removeFirst();
        }
    }

    // optimal approach
    // Time Complexity = O(N)
    // Space Complexity = O(1)

    public static int[] optimalApproach(int[] arr) {
        int pos = 0;
        int neg = 1;

        int[] ans = new int[arr.length];

        for(int i=0; i<arr.length; i++) {
            if(arr[i] < 0 && neg < arr.length) {
                ans[neg] = arr[i];
                neg += 2;
            } else if(pos < arr.length) {
                ans[pos] = arr[i];
                pos += 2;
            }
        }

        return ans;
    }

    // Second Variety : no. of positive elements != no. of negative elements
    // Time Complexity = O(2N)
    // Space Complexity = O(N)
    public static int[] secondVariety(int[] arr) {
        int[] ans = new int[arr.length];
        
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for(int n : arr) {
            if(n < 0) {
                neg.add(n);
            } else {
                pos.add(n);
            }
        }

        int n = Math.min(pos.size(), neg.size());

        for(int i=0; i<n; i++) {
            ans[2*i] = pos.removeLast();
            ans[2*i + 1] = neg.removeLast();
        }

        if(!pos.isEmpty()) {
            for(int i=2*n; i<ans.length; i++) {
                ans[i] = pos.removeLast();
            } 
        } else {
            for(int i=2*n; i<ans.length; i++) {
                ans[i] = neg.removeLast();
            }
        }
        
        
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }

        // // brute approach
        // bruteApproach(arr);
        // printArray(arr);

        // optimal approach
        int[] ans = optimalApproach(arr);
        printArray(ans);

        // second variety
        ans = secondVariety(arr);
        printArray(ans);


        sc.close();
    }
}