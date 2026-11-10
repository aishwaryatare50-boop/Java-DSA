package Striver_A_to_Z_DSA.BinarySearch.BinarySearchOnAnswers;

import java.util.Scanner;

public class FindSquareRootOfANumber {

    // Brute Approach 
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public static int bruteApproach(int n) {
        int ans = 0;
        for(int i=1; i<=n; i++) {
            if(i * i <= n) {
                ans = i;
            } else {
                break;
            }
        }

        return ans;
    }

    // Better Approach 
    // Time Complexity: O(sqrt(n))
    // Space Complexity: O(1)
    public static int betterApproach(int n) {
        for(int i=1; i*i<=n; i++) {
            if(i * i == n) {
                return i;
            }
        }

        return -1;
    }

    // Optimal approach
    // Time Complexity = O(logN)
    // Space Complexity = O(1)
    public static int optimalApproach(int n) {

        if(n == 0 || n == 1) {
            return n;
        }
        
        int low = 1;
        int high = n / 2;
        int ans = 0;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if((long)mid*mid > n) {
                high = mid - 1;
            } else {
                ans = mid;
                low = mid + 1;
            }
        }
    
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number whose square root(floor value) is to be found: ");
        int n = sc.nextInt();

        //Brute approach
        System.out.println("Square root of " + n + " is: " + bruteApproach(n));

        // Better approach
        System.out.println("Square root of " + n + " is: " + betterApproach(n));

        // Optimal approach
        System.out.println("Square root of " + n + " is: " + optimalApproach(n));

       sc.close();
    }
}