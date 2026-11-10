package Striver_A_to_Z_DSA.BinarySearch.BinarySearchOnAnswers;

/*
You are given an integer array bloomDay, an integer m and an integer k.
You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.
The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.
Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.

Example 1:
Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
Output: 3
Explanation: Let us see what happened in the first three days. x means flower bloomed and _ means flower did not bloom in the garden.
We need 3 bouquets each should contain 1 flower.
After day 1: [x, _, _, _, _]   // we can only make one bouquet.
After day 2: [x, _, _, _, x]   // we can only make two bouquets.
After day 3: [x, _, x, _, x]   // we can make 3 bouquets. The answer is 3.

Example 2:
Input: bloomDay = [1,10,3,10,2], m = 3, k = 2
Output: -1
Explanation: We need 3 bouquets each has 2 flowers, that means we need 6 flowers. We only have 5 flowers so it is impossible to get the needed bouquets and we return -1.

Example 3:
Input: bloomDay = [7,7,7,7,12,7,7], m = 2, k = 3
Output: 12
Explanation: We need 2 bouquets each should have 3 flowers.
Here is the garden after the 7 and 12 days:
After day 7: [x, x, x, x, _, x, x]
We can make one bouquet of the first three flowers that bloomed. We cannot make another bouquet from the last three flowers that bloomed because they are not adjacent.
After day 12: [x, x, x, x, x, x, x]
It is obvious that we can make two bouquets in different ways.
 
Constraints:
bloomDay.length == n
1 <= n <= 105
1 <= bloomDay[i] <= 109
1 <= m <= 106
1 <= k <= n
*/

import java.util.Scanner;

public class MinimumDaysToMake_M_Bouquets {

    // Brute Approach
    // Time Complexity: O(n * max(bloomDay))
    // Space Complexity: O(1)
    public static int[] findMaxAndMin(int[] bloomDay) {
        int max = bloomDay[0];
        int min = Integer.MAX_VALUE;

        for(int n : bloomDay) {
            if(n > max) {
                max = n;
            }

            if(n < min) {
                min = n;
            }
        }

        return new int[]{max, min};
    }

    public static boolean canMakeBouquets(int[] bloomDay, int day, int m, int k) {
        int count = 0;
        int noOfBouquets = 0;
        for(int i=0; i<bloomDay.length; i++) {
            if(bloomDay[i] <= day) {
                count++;
            } else {
                noOfBouquets += count / k;
                count = 0;
            }
        }

        noOfBouquets += count / k;

        return noOfBouquets >= m;
    }

    public static int bruteApproach(int[] bloomDay, int m, int k) {
        if(m * k > bloomDay.length) return -1;

        int[] temp = findMaxAndMin(bloomDay);
        int max = temp[0];
        int min = temp[1];

        for(int i=min; i<=max; i++) {
            if(canMakeBouquets(bloomDay, i, m, k)) {
                return i;
            }
        }
        
        return -1;
    }


    // Optimal Approach
    // Time Complexity = O(n * log(max(bloomDay)))
    // Space Complexity = O(1)
    public static int optimalApproach(int[] bloomDay, int m, int k) {
        if((long)m * k > bloomDay.length) return -1;

        int[] temp = findMaxAndMin(bloomDay);
        int low = temp[1];
        int high = temp[0];

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(canMakeBouquets(bloomDay, mid, m, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the bloomDay array: ");
        int size = sc.nextInt();

        int[] bloomDay = new int[size];
        System.out.println("Enter the elements of the bloomDay array: ");
        for(int i=0; i<size; i++) {
            bloomDay[i] = sc.nextInt();
        }

        System.out.print("Enter the number of bouquets(m): ");
        int m = sc.nextInt();

        System.out.print("Enter number of adjacent flowers needed(k): ");
        int k = sc.nextInt();

        // Brute Approach
        System.out.println("Minimum number of days to make " + m + " bouquets (Brute Approach): " + bruteApproach(bloomDay, m, k));

        // Optimal Approach
        System.out.println("Minimum number of days to make " + m + " bouquets (Optimal Approach): " + optimalApproach(bloomDay, m, k));

        sc.close();
    }
}