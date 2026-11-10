package Striver_A_to_Z_DSA.BinarySearch.BinarySearchOnAnswers;

/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).
*/

import java.util.Scanner;

public class MedianOf2SortedArrays {

    // Brute Approach
    // Time Complexity = O(m + n)
    // Space Complexity = O(m + n)
    public static double bruteApproach(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int[] mergedArr = new int[n + m];
        int idx1 = 0;
        int idx2 = 0;
        int idx = 0;

        while(idx1 < n && idx2 < m) {
            if(arr1[idx1] < arr2[idx2]) {
                mergedArr[idx++] = arr1[idx1++];
            } else {
                mergedArr[idx++] = arr2[idx2++];
            }
        }

        while(idx1 < n) {
            mergedArr[idx++] = arr1[idx1++];
        }

        while(idx2 < m) {
            mergedArr[idx++] = arr2[idx2++];
        }

        if((n + m) % 2 == 0) {
            return (mergedArr[(n + m) / 2] + mergedArr[(n + m) / 2 - 1]) / 2.0;
        } else {
            return mergedArr[(n + m) / 2];
        }
    }


    // Better Approach
    // Time Complexity = O(m + n)
    // Space Complexity = O(1)
    public static double betterApproach(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int medianIdx1 = -1;
        int medianIdx2 = -1;
        if((n + m) % 2 == 0) {
            medianIdx1 = (n + m) / 2;
            medianIdx2 = (n + m) / 2 - 1;
        } else {
            medianIdx1 = (n + m) / 2;
        }

        int count = 0;
        int idx1 = 0;
        int idx2 = 0;
        int temp1 = -1;
        int temp2 = -1;

        while(idx1 < n && idx2 < m) {
            if(arr1[idx1] < arr2[idx2]) {
                if(count == medianIdx1) {
                    temp1 = arr1[idx1];
                }

                if(count == medianIdx2) {
                    temp2 = arr1[idx1];
                }
                count++;
                idx1++;
            } else {
                if(count == medianIdx1) {
                    temp1 = arr2[idx2];
                }

                if(count == medianIdx2) {
                    temp2 = arr2[idx2];
                }
                count++;
                idx2++;
            }
        }

        while(idx1 < n) {
            if(count == medianIdx1) {
                temp1 = arr1[idx1];
            }

            if(count == medianIdx2) {
                temp2 = arr1[idx1];
            }
            count++;
            idx1++;
        }

        while(idx2 < m) {
            if(count == medianIdx1) {
                temp1 = arr2[idx2];
            }

            if(count == medianIdx2) {
                temp2 = arr2[idx2];
            }
            count++;
            idx2++;
        }

        if(medianIdx2 == -1) {
            return temp1;
        } else {
            return (temp1 + temp2) / 2.0;
        }
    }


    // Optimal Approach
    // Time Complexity = O(log(min(m, n)))
    // Space Complexity = O(1)
    public static double optimalApproach(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;

        if(n > m) {
            return optimalApproach(arr2, arr1);
        }

        int low = 0;
        int high = n;
        int eleReqOnLeft = (n + m + 1) / 2;
        
        
        while(low <= high) {
            int mid1 = low + (high - low) / 2;
            int mid2 = eleReqOnLeft - mid1;
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
                if((n + m) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    return Math.max(l1, l2);
                }
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

        // brute approach
        System.out.println("Median of two sorted arrays is: " + bruteApproach(arr1, arr2));

        // better approach
        System.out.println("Median of two sorted arrays is: " + betterApproach(arr1, arr2));

        // optimal approach
        System.out.println("Median of two sorted arrays is: " + optimalApproach(arr1, arr2));

        sc.close();
    }
}