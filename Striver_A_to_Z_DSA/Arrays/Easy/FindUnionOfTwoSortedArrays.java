package Striver_A_to_Z_DSA.Arrays.Easy;

import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Scanner;

public class FindUnionOfTwoSortedArrays {

    static Scanner sc = new Scanner(System.in);

    public static void printArray(int[] arr) {
        for(int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static int[] inputArray() {
        System.out.print("Enter size of array : ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }

        quickSort(arr, 0, size-1);

        return arr;
    }

    public static void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int pidx = partition(arr, low, high);

            quickSort(arr, low, pidx - 1);
            quickSort(arr, pidx + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for(int j=low; j<high; j++) {
            if(arr[j] < pivot) {
                i++;
                // swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        i++;
        // swap
        int temp = arr[i];
        arr[i] = pivot;
        arr[high] = temp;

        return i; // pivot index
    }

    // brute approach 
    // Time Complexity = O(N1logN + N2logN + N1 + N2)
    // Space Complexity = O(N1 + N2) + O(N1 + N2) // this is extra space for answer
    public static int[] bruteApproach(int[] arr1, int[] arr2) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0; i<arr1.length; i++) {
            set.add(arr1[i]);
        }

        for(int i=0; i<arr2.length; i++) {
            set.add(arr2[i]);
        }

        int[] union = new int[set.size()];
        for(int i=0; i<union.length; i++) {
            union[i] = set.removeFirst();
        }

        return union;
    }

    // optimal approach
    // Time Complexity = O(N1 + N2)
    // Space Complexity = O(N1 + N2)
    public static int[] optimalSolution(int[] arr1, int[] arr2) {
        int idx1 = 0;
        int idx2 = 0;
        ArrayList<Integer> temp = new ArrayList<>();

        while(idx1 < arr1.length && idx2 < arr2.length) {
            if(arr1[idx1] <= arr2[idx2]) {
                if(temp.isEmpty() || arr1[idx1] != temp.getLast()) {
                    temp.add(arr1[idx1]);
                }
                idx1++;
            } else {
                if(temp.isEmpty() || arr2[idx2] != temp.getLast()) {
                    temp.add(arr2[idx2]);
                }
                idx2++;
            }
        }

        while(idx1 < arr1.length) {
            if(temp.isEmpty() || arr1[idx1] != temp.getLast()) {
                    temp.add(arr1[idx1]);
                }
                idx1++;
        }

        while(idx2 < arr2.length) {
            if(temp.isEmpty() || arr2[idx2] != temp.getLast()) {
                    temp.add(arr2[idx2]);
                }
                idx2++;
        }

        int[] union = new int[temp.size()];
        for(int i=0; i<union.length; i++) {
            union[i] = temp.removeFirst();
        }

        return union;
    }


    public static void main(String[] args) {

        int[] arr1 = inputArray();
        int[] arr2 = inputArray();

        int[] union = bruteApproach(arr1, arr2);
        printArray(union);  
        
        union = optimalSolution(arr1, arr2);
        printArray(union);
    }
}