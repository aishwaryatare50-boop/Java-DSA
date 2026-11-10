package Striver_A_to_Z_DSA.Arrays.Hard;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.HashSet;
import java.util.Arrays;

public class FourSum {

    // brute approach
    // Time Complexity = O(N^4)
    // Space Complexity = O(N)
    public static ArrayList<ArrayList<Integer>> bruteSolution(int[] arr, int target) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        HashSet<ArrayList<Integer>> set = new HashSet<>();

        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                for(int k=j+1; k<arr.length; k++) {
                    for(int l=k+1; l<arr.length;l++) {
                        if(arr[i] + arr[j] + arr[k] + arr[l] == target) {
                            ArrayList<Integer> temp = new ArrayList<>(List.of(arr[i], arr[j], arr[k], arr[l]));
                            Collections.sort(temp);
                            if(set.add(temp)) {
                                ans.add(temp);
                            }

                        }
                    }
                }
            }
        }

        return ans;
    }

    // better approach
    // Time Complexity = O(N^3)
    // Space Complexity = O(N)
    public static ArrayList<ArrayList<Integer>> betterSolution(int[] arr, int target) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        HashSet<ArrayList<Integer>> set = new HashSet<>();

        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                HashSet<Integer> st = new HashSet<>();
                for(int k=j+1; k<arr.length; k++) {
                    int arrL = target - (arr[i] + arr[j] + arr[k]);
                    if(st.contains(arrL)) {
                        ArrayList<Integer> temp = new ArrayList<>(List.of(arr[i], arr[j], arr[k], arrL));
                        Collections.sort(temp);
                        if(set.add(temp)) {
                            ans.add(temp);
                        }
                    }
                    st.add(arr[k]);
                }
            }
        }

        return ans;
    }

    // Optimal approach
    // Time Complexity = O(N^3)
    // Space Complexity = O(1)
    public static ArrayList<ArrayList<Integer>> optimalSolution(int[] arr, int target) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        // step-1: first sort array
        Arrays.sort(arr);

        // step-2: now use a two pointer approach with for loop
        for(int i=0; i<arr.length; i++) {
            if(i > 0 && arr[i] == arr[i-1]) continue;

            for(int j=i+1; j<arr.length; j++) {
                if(j != i + 1 && arr[j] == arr[j-1]) continue;

                int k = j + 1;
                int l = arr.length - 1;

                while(k < l) {
                    int sum = arr[i] + arr[j] + arr[k] + arr[l];
                    if(sum == target) {
                        ArrayList<Integer> temp = new ArrayList<>(List.of(arr[i], arr[j], arr[k], arr[l]));
                        ans.add(temp);

                        k++;
                        l--;

                        while(k < l && arr[k] == arr[k-1]) k++;
                        while(k < l && arr[l] == arr[l+1]) l--;
                    } else if(sum < target) {
                        k++;
                    } else if(sum > target) {
                        l--;
                    }
                    
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

        System.out.print("Enter target: ");
        int target = sc.nextInt();

        // brute solution
        System.out.println(bruteSolution(arr, target));

        // better solution
        System.out.println(betterSolution(arr, target));

        // optimal solution
        System.out.println(optimalSolution(arr, target));

        sc.close();
    }
}