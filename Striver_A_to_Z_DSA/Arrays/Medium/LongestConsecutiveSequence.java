package Striver_A_to_Z_DSA.Arrays.Medium;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class LongestConsecutiveSequence {

    // brute approach
    // Time Complexity = O(N^2)
    // Space Complexity = O(1) // O(N) for returning solution
    public static boolean isPresent(int[] arr, int target) {

        for(int n : arr) {
            if(n == target) return true;
        }

        return false;
    }

    public static ArrayList<Integer> bruteSolution(int[] arr) {
        ArrayList<Integer> longSeq = new ArrayList<>()  ;

        int longest = 0;
        for(int i=0; i<arr.length; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            int x = arr[i];
            int count = 1;
            temp.add(x);

            while (isPresent(arr, x + 1)){
                x++;
                temp.add(x);
                count++;
            }

            if(count > longest) {
                    longest = count;
                    longSeq = new ArrayList<>(temp);
                }
        }

        return longSeq;
    }

    // better solution
    // Time Complexity = O(NlogN + N) = O(NlogN)
    // Space Complexity = O(1)

    public static ArrayList<Integer> betterSolution(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        ArrayList<Integer> longSeq = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();

        int count = 0;
        int lastSmall = Integer.MIN_VALUE;
        int longest = 0;

        for(int i=0; i<arr.length; i++) {
            if(arr[i] - 1 == lastSmall) {
                count++;
                lastSmall = arr[i];
                temp.add(arr[i]);
            } 
            else if(arr[i] != lastSmall) {
                count = 1;
                temp = new ArrayList<>();
                temp.add(arr[i]);
                lastSmall = arr[i];
            } 

            if(count > longest) {
                longest = count;
                longSeq = new ArrayList<>(temp);
            }
        }

        return longSeq;
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for(int j=low; j<=high; j++) {
            if(arr[j] < pivot) {
                i++;
                // swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // placement
        i++;
        int temp = arr[i];
        arr[i] = pivot;
        arr[high] = temp;
        
        return i; // pivot index
    }

    public static void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int pidx = partition(arr, low, high);
            
            quickSort(arr, low, pidx-1);
            quickSort(arr, pidx+1, high);
        }
    }

    // optimal solution
    // Time Complexity = O(3N)
    // Space Complexity = O(N)
    public static ArrayList<Integer> opimalSolution(int[] arr) {
        if(arr.length == 0) {
            return null;
        }

        ArrayList<Integer> longSeq = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<arr.length; i++) {
            set.add(arr[i]);
        }

        Iterator<Integer> it = set.iterator();
        int longest = 0;
        while(it.hasNext()) {
            int currEle = it.next();
            ArrayList<Integer> temp = new ArrayList<>();
            if(!set.contains(currEle - 1)) {
                int x = currEle;
                temp.add(x);
                int count = 1;
                while (set.contains(x + 1)){
                    x++;
                    count++;
                    temp.add(x);
                }
                if(count > longest) {
                    longest = count;
                    longSeq = new ArrayList<>(temp);
                }
            }
        }

        return longSeq;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }

        // brute solution
        System.out.println("Longest Consecutive Sequence in given array is: " + bruteSolution(arr) + " with length " + bruteSolution(arr).size() + ".");

        //better solution
        System.out.println("Longest Consecutive Sequence in given array is: " + betterSolution(arr) + " with length " + betterSolution(arr).size() + ".");

        // optimal solution
        System.out.println("Longest Consecutive Sequence in given array is: " + opimalSolution(arr) + " with length " + opimalSolution(arr).size() + ".");

        sc.close();
    }
}