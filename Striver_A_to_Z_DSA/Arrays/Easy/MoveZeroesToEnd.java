package Striver_A_to_Z_DSA.Arrays.Easy;

import java.util.ArrayList;
import java.util.Scanner;

public class MoveZeroesToEnd {
    
    public static void printArray(int[] arr) {
        for(int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    // Time Complexity = O(2N), Space Complexity = O(N)
    public static void bruteApproach(int[] arr) {
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i=0; i<arr.length; i++) {
            if(arr[i] != 0) {
                temp.add(arr[i]);
            }
        }

        int nonZero = temp.size();
        int i = 0;
        for(int n : temp) {
            arr[i] = n;
            i++;
        }

        for(int j=nonZero; j<arr.length; j++) {
            arr[j] = 0;
        }
    }

    // optimal solution
    // Time Complexity = O(N), Space Complexity = O(1)// We are considering only extra space complexity
    public static void optimalSolution(int[] arr) {
        int j = -1;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == 0 && j == -1) {
                j = i;
            }

            if(arr[i] != 0 && j != -1) {
                arr[j] = arr[i];
                arr[i] = 0;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array : ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }

        // bruteApproach(arr);
        // printArray(arr);

        optimalSolution(arr);
        printArray(arr);

        sc.close();
    }
}