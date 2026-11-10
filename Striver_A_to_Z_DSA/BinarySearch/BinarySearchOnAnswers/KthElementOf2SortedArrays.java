package Striver_A_to_Z_DSA.BinarySearch.BinarySearchOnAnswers;

import java.util.Scanner;

public class KthElementOf2SortedArrays {

    public static int kthElement(int[] arr1, int[] arr2, int k) {
        int n = arr1.length;
        int m = arr2.length;

        if(n > m) {
            return kthElement(arr2, arr1, k);
        }

        int low = Math.max(k - m, 0); // if k > m then we have to take at least k - m elements from arr1
        int high = Math.min(k, n);
        int left = k;

        while(low <= high) {
            int mid1 = low + (high - low) / 2;
            int mid2 = left - mid1;

            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;

            if(mid1 != 0) {
                l1 = arr1[mid1 - 1];
            }

            if(mid2 != 0) {
                l2 = arr2[mid2 - 1];
            }

            if(mid1 != n) {
                r1 = arr1[mid1];
            }

            if(mid2 != m) {
                r2 = arr2[mid2];
            }

            if(l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if(l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }

        return -1;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of first array: ");
        int n = sc.nextInt();

        System.out.print("Enter the size of second array: ");
        int m = sc.nextInt();

        int[] arr1 = new int[n];
        int[] arr2 = new int[m];

        System.out.println("Enter the elements of first array: ");
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }

        System.out.println("Enter the elements of second array: ");
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }

        System.out.print("Enter the value of k: ");
        int k = sc.nextInt();

        // brute approach will have time complexity of O(n+m) and space complexity of O(n+m). In this approach we will merge both the arrays and then return the kth element from the merged array.

        // Optimal Approach
        // Time Complexity = O(log(min(n, m)))
        // Space Complexity = O(1)

        System.out.println("Kth element of two sorted arrays is: " + kthElement(arr1, arr2, k));

        sc.close();
    }
}