package Striver_A_to_Z_DSA.Arrays.Hard;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class ThreeSum {

    // brute solution
    // Time Complexity = O(N^3)
    // Space Complexity = O(N)
    public static ArrayList<ArrayList<Integer>> bruteSolution(int[] arr) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        HashSet<ArrayList<Integer>> set = new HashSet<>();

        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                for(int k=j+1; k<arr.length; k++) {
                    if(arr[i] + arr[j] + arr[k] == 0) {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[k]);
                        Collections.sort(temp);
                        if(!set.contains(temp)) {
                            ans.add(new ArrayList<>(temp));;
                            set.add(temp);
                        }
                        
                    }
                }
            }
        }

        return ans;
    }

    // better solution
    // Time Complexity = O(N^2)
    // Space Complexity = O(N)
    public static ArrayList<ArrayList<Integer>> betterSolution(int[] arr) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        HashSet<ArrayList<Integer>> set = new HashSet<>();

        for(int i=0; i<arr.length; i++) {
            HashSet<Integer> st = new HashSet<>();
            for(int j=i+1; j<arr.length; j++) {
                int third = - (arr[i] + arr[j]);
                if(st.contains(third)) {
                    ArrayList<Integer> temp = new ArrayList<>(List.of(arr[i], arr[j], third));
                    Collections.sort(temp);
                    if(set.add(temp)) {
                        ans.add(temp);
                    }
                }

                st.add(arr[j]);
            }
        }

        return ans;
    }

    // optimal solution
    // Time Complexity = O(N^2 + Nlogn)
    // Space Complexity = O(1)
    public static ArrayList<ArrayList<Integer>> optimalSolution(int[] arr) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        // step-1: first sort array
        Arrays.sort(arr);

        // step-2: now use two pointer approach
        for(int i=0; i<arr.length; i++) {
            if(i > 0 && arr[i] == arr[i-1]) continue;

            int j = i + 1;
            int k = arr.length - 1;
            while(j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if(sum < 0) {
                    j++;
                } 
                else if(sum > 0) {
                    k--;
                }
                else {
                    ArrayList<Integer> temp = new ArrayList<>(List.of(arr[i], arr[j], arr[k]));
                    ans.add(temp);
                    j++;
                    k--;
                    while(j < k && arr[j] == arr[j - 1]) j++;
                    while(j < k && arr[k] == arr[k + 1]) k--;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }

        // brute solution
        System.out.println(bruteSolution(arr));

        // better solution
        System.out.println(betterSolution(arr));

        // optimal solution
        System.out.println(optimalSolution(arr));

        sc.close();
    }    
}