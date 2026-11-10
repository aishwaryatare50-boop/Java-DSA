package Striver_A_to_Z_DSA.Arrays.Medium;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class PreviousPermutation {

    // brute approach
    // Time Complexity = O(N! * N)
    // Space Complexity = O(N!)

    public static ArrayList<Integer> conArrToArrList(int[] arr) {
        ArrayList<Integer> al = new ArrayList<>();
        for(int n : arr) {
            al.add(n);
        }

        return al;
    }

    public static void permutations(ArrayList<ArrayList<Integer>> allPermutations, ArrayList<Integer> al, ArrayList<Integer> temp) {
        if(al.size() == 0) {
            allPermutations.add(new ArrayList<>(temp));
            return;
        }

        for(int i=0; i<al.size(); i++) {
            ArrayList<Integer> al2 = new ArrayList<>(al);
            al2.remove(i);
            temp.add(al.get(i));
            permutations(allPermutations, al2, temp);
            temp.remove(temp.size()-1);
        }
    }

    public static ArrayList<Integer> bruteApproach(int[] arr) {
        ArrayList<ArrayList<Integer>> allPermutations = new ArrayList<>();
        ArrayList<Integer> prevPerm = new ArrayList<>();

        permutations(allPermutations, conArrToArrList(arr), new ArrayList<>());
        Collections.sort(allPermutations, (a, b) -> {
            for(int i=0; i<a.size(); i++) {
                if(!a.get(i).equals(b.get(i))) {
                    return a.get(i) - b.get(i);
                }
            }
            return 0;
        } );

        for(int i=0; i<allPermutations.size(); i++) {
            if(allPermutations.get(i).equals(conArrToArrList(arr))) {
                if(i != 0) {prevPerm = allPermutations.get((i - 1) % allPermutations.size());}
                else {
                    prevPerm = allPermutations.get(allPermutations.size()-1);
                }
                break;

            }
        }

        return prevPerm;
    }

    // optimal approach
    // Time complexity = O(3N)
    // Space Complexity = O(1)
    public static void prevPermutation(int[] arr) {
        int n = arr.length;

        // step-1
        int breakPoint = -1;
        
        for(int i=n-2; i>=0; i--) {
            if(arr[i] > arr[i+1]) {
                breakPoint = i;
                break;
            }
        }

        if(breakPoint == -1) {
            reverseArr(arr, 0, n-1);
            return;
        }

        // step-2
        int max = Integer.MIN_VALUE;
        int maxIdx = -1;
        for(int i=breakPoint+1; i<n; i++) {
            if(arr[i] >= max && arr[i] < arr[breakPoint]) {
                max = arr[i];
                maxIdx = i;
            }
        }
        //swap
        int temp = arr[breakPoint];
        arr[breakPoint] = max;
        arr[maxIdx] = temp;

        // step-3
        reverseArr(arr, breakPoint+1, n-1);

    }

    public static void reverseArr(int[] arr, int si, int ei) {
        while(si < ei) {
            int temp = arr[si];
            arr[si] = arr[ei];
            arr[ei] = temp;
            si++;
            ei--;
        }
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
        prevPermutation(arr);
        for(int i=0; i<size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        sc.close();
    }
}