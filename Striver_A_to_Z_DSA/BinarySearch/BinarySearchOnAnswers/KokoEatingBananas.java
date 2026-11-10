package Striver_A_to_Z_DSA.BinarySearch.BinarySearchOnAnswers;

/*
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.

 

Example 1:

Input: piles = [3,6,7,11], h = 8
Output: 4
Example 2:

Input: piles = [30,11,23,4,20], h = 5
Output: 30
Example 3:

Input: piles = [30,11,23,4,20], h = 6
Output: 23
 

Constraints:

1 <= piles.length <= 104
piles.length <= h <= 109
1 <= piles[i] <= 109
*/

import java.util.Scanner;

public class KokoEatingBananas {

    // Brute Approach
    // Time Complexity = O(N * max(piles))
    // Space Complexity = O(1)
    public static int findMax(int[] arr) {
        int max = arr[0];

        for(int n : arr) {
            if(n > max) {
                max = n;
            }
        }

        return max;
    }

    public static int timeRequiredToEat(int[] arr, int rateOfEatingBananas) {
        int totalHours = 0;

        for(int n : arr) {
            int ceil = Math.ceilDiv(n, rateOfEatingBananas);
            totalHours += ceil;
        }

        return totalHours;
    }

    public static int bruteApproach(int[] piles, int deadline) {
        int max = findMax(piles);

        for(int i=1; i<= max; i++) {
            int timeRequired = timeRequiredToEat(piles, i);
            if(timeRequired <= deadline) {
                return i;
            } 
        }

        return -1;
    }


    // Optimal Approach
    // Time Complexity = O(n * log(max(piles)))
    public static int optimalApproach(int[] piles, int deadline) {
        int max = findMax(piles);
        int low = 1;
        int high = max;
        int ans = -1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            int timeRequired = timeRequiredToEat(piles, mid);

            if(timeRequired <= deadline) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of piles: ");
        int n = sc.nextInt();

        int[] piles = new int[n];
        System.out.println("Enter number of bananas in each pile: ");
        for(int i=0; i<n; i++) {
            piles[i] = sc.nextInt();
        }

        System.out.print("Enter deadline: ");
        int deadline = sc.nextInt();
        
        // brute approach
        System.out.println("Minimum eating speed (brute approach): " + bruteApproach(piles, deadline));

        // optimal approach
        System.out.println("Minimum eating speed (optimal approach): " + optimalApproach(piles, deadline));
        
        sc.close();
    }
}