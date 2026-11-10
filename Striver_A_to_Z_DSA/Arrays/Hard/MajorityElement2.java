package Striver_A_to_Z_DSA.Arrays.Hard;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

// Elements apppearing more than [n/3] will be considered majority element.

public class MajorityElement2 {
    
        // Brute approach
        // Time complexity = O(N^2)
        // Space complexity = O(1)
        public static void bruteApproach(int[] arr) {
            int[] ans = new int[2];
            ans[0] = Integer.MIN_VALUE;
            ans[1] = Integer.MIN_VALUE;

            for(int n : arr) {
                int freq = linearSearch(arr, n);
                if(freq > arr.length / 3) {
                    if(ans[0] != Integer.MIN_VALUE && ans[0] != n) {
                        ans[1] = n;
                    } else {
                        ans[0] = n;
                    }
                }
            }

            if(ans[0] == Integer.MIN_VALUE) {
                System.out.println("There is no majority element in array.");
            } else if(ans[1] == Integer.MIN_VALUE) {
                System.out.println("Majority element is: " + ans[0]);
            } else {
                System.out.println("Majority elements are " + ans[0] + " and " + ans[1] + ".");
            }
        }

        public static int linearSearch(int[] arr, int target) {
            int count = 0;
            for(int n : arr) {
                if(n == target) {
                    count++;
                }
            }

            return count;
        }

        // Better approach
        // Time complexity = O(N)
        // Space complexity = O(N)
        public static void betterSolution(int[] arr) {
            int[] ans = new int[2];
            ans[0] = Integer.MIN_VALUE;
            ans[1] = Integer.MIN_VALUE;
            HashMap<Integer, Integer> map = new HashMap<>();

            for(int i=0; i<arr.length; i++) {
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
                int freq = map.get(arr[i]);
                int n = arr[i];
                if(freq > arr.length / 3) {
                    if(ans[0] != Integer.MIN_VALUE && ans[0] != n) {
                        ans[1] = n;
                    } else {
                        ans[0] = n;
                    }
                }
            }

            if(ans[0] == Integer.MIN_VALUE) {
                System.out.println("There is no majority element in array.");
            } else if(ans[1] == Integer.MIN_VALUE) {
                System.out.println("Majority element is: " + ans[0]);
            } else {
                System.out.println("Majority elements are " + ans[0] + " and " + ans[1] + ".");
            }
        }

        // Optimal approach
        // Time complexity = O(N)
        // Space complexity = O(1)
        public static void optimalSolution(int[] arr) {
            int count1 = 0, count2 = 0;
            int el1 = Integer.MIN_VALUE, el2 = Integer.MIN_VALUE;

            for(int n : arr) {
                if(count1 == 0 && el2 != n) {
                    el1 = n;
                    count1++;
                } 
                else if(count2 == 0 && el1 != n) {
                    el2 = n;
                    count2++;
                }
                else if(n == el1) count1++;
                else if(n == el2) count2++;
                else {
                    count1--;
                    count2--;
                }
            }

            int freq1 = 0, freq2 = 0;
            ArrayList<Integer> ans = new ArrayList<>();
            
            for(int n : arr) {
                if(n == el1) {
                    freq1++;
                } 
                else if(n == el2) {
                    freq2++;
                }
            }

            if(freq1 > arr.length / 3) {
                ans.add(el1);
            }

            if(freq2 > arr.length / 3) {
                ans.add(el2);
            }

            if(ans.size() == 0) {
                System.out.println("No majority element.");
            } 
            else if(ans.size() == 1){
                System.out.println("Majority elements is: " + ans);
            }
            else {
                System.out.println("Majority elements are: " + ans);
            }

        }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }

        // brute approach
        bruteApproach(arr);

        // better approach
        betterSolution(arr);

        // optimal approach
        optimalSolution(arr);

        sc.close();
    }    
}