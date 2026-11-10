package Striver_A_to_Z_DSA.Arrays.Medium;

import java.util.Scanner;
import java.util.ArrayList;

public class LeadersInArray {

    // brute approach
    // Time Complexity = O(N^2)
    // Space Complexity = O(1) // for returning solution O(N)
    public static boolean isLeader(int[] arr, int si) {
        for(int i=si+1; i<arr.length; i++) {
            if(arr[si] < arr[i]) {
                return false;
            }
        }

        return true;
    }

    public static ArrayList<Integer> bruteApproach(int[] arr) {
        ArrayList<Integer> leaders = new ArrayList<>();

        for(int i=0; i<arr.length; i++) {
            if(isLeader(arr, i)) {
                leaders.add(arr[i]);
            }
        }

        return leaders;
    }

    // optimal approach
    // Time complexity = O(N)
    // Space Complexity = O(1) // O(N) for returning solution
    public static ArrayList<Integer> leadersInArray(int[] arr) {
        ArrayList<Integer> leaders = new ArrayList<>();

        int max = Integer.MIN_VALUE;
        for(int i=arr.length-1; i>=0; i--) {
            if(arr[i] > max) {
                leaders.add(arr[i]);
                max = arr[i];
            }
        }

        return leaders;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }

        // brute approach
        System.out.println(bruteApproach(arr));

        // optimal approach
        System.out.println(leadersInArray(arr));

        sc.close();
    }    
}