package Striver_A_to_Z_DSA.Arrays.Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class NextPermutation {

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

    public static void permutations(ArrayList<Integer> al, ArrayList<ArrayList<Integer>> allPermutations, ArrayList<Integer> temp) {
        if(al.size() == 0) {
            allPermutations.add(new ArrayList<>(temp));
            return;
        }

        for(int i=0; i<al.size(); i++) {
            ArrayList<Integer> al2 = new ArrayList<>(al);
            al2.remove(i);
            temp.add(al.get(i));
            permutations(al2, allPermutations, temp);
            temp.remove(temp.size()-1);
        }
    }

    public static ArrayList<Integer> bruteApproach(int[] arr) {
        ArrayList<Integer> al = conArrToArrList(arr);
        ArrayList<ArrayList<Integer>> allPermutations = new ArrayList<>();
        permutations(al, allPermutations, new ArrayList<>());

        Collections.sort(allPermutations, (a, b) -> {
            for (int i = 0; i < a.size(); i++) {
                if (!a.get(i).equals(b.get(i))) {
                    return a.get(i) - b.get(i);
                }
            }
            return 0;
        });

        for(int i=0; i<allPermutations.size(); i++) {
            if(allPermutations.get(i).equals(al)) {
                return allPermutations.get((i+1)%allPermutations.size());
            }
        }

        return null;
    }

    // optimal approach
    // Time complexity = O(3N)
    // Space Complexity = O(1)
    public static int[] nextPermutation(int[] arr) {
        // step-1
        int breakPoint = -1;
        for(int i=arr.length-2; i>=0; i--) {
            if(arr[i] < arr[i+1]) {
                breakPoint = i;
                break;
            }
        }

        if(breakPoint == -1) {
            reverseArr(arr, 0, arr.length-1);
            return arr;
        }

        // step-2
        int min = Integer.MAX_VALUE;
        int minIdx = -1;

        for(int i=breakPoint+1; i<arr.length; i++) {
            if(arr[i] <= min && arr[i] > arr[breakPoint]) {
                min = arr[i];
                minIdx = i; 
            }
        }

        // swap
        int temp = arr[minIdx];
        arr[minIdx] = arr[breakPoint];
        arr[breakPoint] = temp;

        // step 3
        reverseArr(arr, breakPoint + 1, arr.length-1); // since array is already sorted in descending order we just reverse it

        return arr;
    }

    public static void reverseArr(int[] arr, int si, int ei) {
        while(si <= ei) {
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

        // brute force
        ArrayList<Integer> ans = bruteApproach(arr);
        System.out.println(ans);

        // optimal approach
        int[] array = nextPermutation(arr);
        for(int i=0; i<array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

    
        sc.close();
    }    
}