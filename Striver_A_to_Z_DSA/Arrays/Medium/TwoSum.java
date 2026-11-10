package Striver_A_to_Z_DSA.Arrays.Medium;

import java.util.HashMap;
import java.util.Scanner;

public class TwoSum {

    // brute approach
    // Time Complexity = O(N^2)
    // Space Complexity = O(1)
    public static int[] bruteApproach(int[] arr, int target) {
        int[] ans = new int[2];
        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                if(arr[i] + arr[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }

        return ans;
    }

    // better approach
    // Time Complexity = O(N) // O(N^2) in worst case
    // Space Complexity = O(N)
    public static int[] betterSolution(int[] arr, int target) {
        int[] ans = new int[2];

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++) {
            int curr = arr[i];

            if(map.containsKey(target - curr)) {
                ans[0] = map.get(target - curr);
                ans[1] = i;
                break;
            }

            map.put(curr, i);
        }

        return ans;
    }

    // optimal approach
    // Time Complexity = O(NlogN) + O(N)
    // Space Complexity = O(1)
    public static int[] optimalSolution(int[] arr, int target) {
        int[] ans = new int[2];



        return ans;
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array : ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter target: ");
        int target = sc.nextInt();

        int[] ans = bruteApproach(arr, target);

        // brute approach
        System.out.println("Indices having sum equal to " + target + " in above array are " + ans[0] + " and " + ans[1] + ".");

        // better approach
        ans = betterSolution(arr, target);
        System.out.println("Indices having sum equal to " + target + " in above array are " + ans[0] + " and " + ans[1] + ".");

        sc.close();
    }
}