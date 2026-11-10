package Striver_A_to_Z_DSA.Arrays.Hard;

import java.util.Scanner;
import java.util.Arrays;

public class MergeSortedArraysWithoutExtraSpace {
    static Scanner sc = new Scanner(System.in);

    public static void printArray(int[] arr) {
        for(int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static void inputArray(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            arr[i] = sc.nextInt();
        }
    }

    // Brute approach
    // Time Complexity = O(N + M)
    // Space Complexity = O(N + M)
    public static void bruteApproach(int[] arr1, int[] arr2) {
        int[] merged = new int[arr1.length + arr2.length];
        int idx1 = 0;
        int idx2 = 0;
        int i = 0;

        while(idx1 < arr1.length && idx2 < arr2.length) {
            if(arr1[idx1] < arr2[idx2]) {
                merged[i++] = arr1[idx1++];
            } else {
                merged[i++] = arr2[idx2++];
            }
        }

        while(idx1 < arr1.length) {
            merged[i++] = arr1[idx1++];
        }

        while(idx2 < arr2.length) {
            merged[i++] = arr2[idx2++];
        }

        for(int j=0; j<merged.length; j++) {
            if(j < arr1.length) {
                arr1[j] = merged[j];
            } else {
                arr2[j - arr1.length] = merged[j];
            }
        }
    }

    // Optimal approach - 1
    // Time Complexity = O(min(N, M)) + O(NlogN) + O(MlogM)
    // Space Complexity = O(1)
    public static void optimalApproach1(int[] arr1, int[] arr2) {
        int left = arr1.length-1;
        int right = 0;

        while(left >= 0 && right < arr2.length) {
            if(arr1[left] > arr2[right]) {
                swap(arr1, arr2, left, right);
                left-- ;
                right++;
            } else {
                break;
            }
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    // Optimal approach - 2
    // Time Complexity = O{(N+M)log(N+M)}
    // Space Complexity = O(1)
    public static void optimalApproach2(int[] arr1, int[] arr2) {
        // gap method from shell sort
        int length = arr1.length + arr2.length;
        int gap = (length / 2) + (length % 2);

        while(gap > 0) {
            int left = 0;
            int right = left + gap;
            while(right < length) {
                // left in arr1 and right in arr2
                if(left < arr1.length && right >= arr1.length) {
                    if(arr1[left] > arr2[right - arr1.length]) {
                        swap(arr1, arr2, left, right - arr1.length);
                    }
                } 
                // both left and right in arr2
                else if(left >= arr1.length) {
                    if(arr2[left - arr1.length] > arr2[right - arr1.length]) {
                        swap(arr2, arr2, left - arr1.length, right - arr1.length);
                    }
                }
                // both left and right in arr1
                else {
                    if(arr1[left] > arr1[right]) {
                        swap(arr1, arr1, left, right);
                    }
                }
                left++;
                right++;
            }

            if(gap == 1) {
                break;
            }

            gap = (gap / 2) + (gap % 2);
        }
    }

    private static void swap(int[] arr1, int[] arr2, int idx1, int idx2) {
        int temp = arr1[idx1];
        arr1[idx1] = arr2[idx2];
        arr2[idx2] = temp;
    }

    public static void main(String[] args) {
        System.out.print("Enter size of array one: ");
        int size1 = sc.nextInt();

        System.out.print("Enter size of array two: ");
        int size2 = sc.nextInt();

        int[] arr1 = new int[size1];
        inputArray(arr1);
        int[] arr2 = new int[size2];
        inputArray(arr2);

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        System.out.println();

        // // brute approach
        // bruteApproach(arr1, arr2);
        // printArray(arr1);
        // printArray(arr2);

        // // optimal approach 1
        // optimalApproach1(arr1, arr2);
        // printArray(arr1);
        // printArray(arr2);

        // optimal approach 2
        optimalApproach2(arr1, arr2);
        printArray(arr1);
        printArray(arr2);
    }
}