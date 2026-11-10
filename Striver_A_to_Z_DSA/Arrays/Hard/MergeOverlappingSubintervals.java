package Striver_A_to_Z_DSA.Arrays.Hard;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;

public class MergeOverlappingSubintervals {

    // brute solution
    // Time Complexity = O(N^2)
    // Space Complexity = O(N) // for returning answer
    public static ArrayList<ArrayList<Integer>> bruteSolution(int[][] intervals) {
        ArrayList<ArrayList<Integer>> overlappingIntervals = new ArrayList<>();

        // step-1: sort intervals
        Arrays.sort(intervals, Comparator.comparingInt((int[] a) -> a[0]).thenComparing(a -> a[1]));

        for(int i=0; i<intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if(!overlappingIntervals.isEmpty() && end <= overlappingIntervals.getLast().get(1)) {
                continue;
            }
            
            for(int j=i+1; j<intervals.length; j++) {
                if(intervals[j][0] <= end) {
                    if(end < intervals[j][1]) {
                        end = intervals[j][1];
                    }
                } else {
                    break;
                }
            }

            overlappingIntervals.add(new ArrayList<>(List.of(start, end)));
        }


        return overlappingIntervals;
    }

    // optimal solution
    // Time Complexity = O(NLogN)
    // Space Complexity = O(1) // O(N) for returning answer
    public static ArrayList<ArrayList<Integer>> optimalSolution(int[][] intervals) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        // sort the intervals
        Arrays.sort(intervals, Comparator.comparingInt((int[] a) -> a[0]).thenComparing(a -> a[1]));

        for(int i=0; i<intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(ans.isEmpty() || start > ans.getLast().get(1)) {
                ans.add(new ArrayList<>(List.of(start, end)));
            } else {
                if(end > ans.getLast().get(1)) {
                    ans.getLast().set(1, end);
                }
            }
            
        }

        return ans;
    }
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of subintervals: ");
        int n = sc.nextInt();

        int[][] intervals = new int[n][2];
        for(int i=0; i<n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }

        // brute approach
        System.out.println(bruteSolution(intervals));

        // optimal approach
        System.out.println(optimalSolution(intervals));

        sc.close();
    }
}