package Striver_A_to_Z_DSA.Arrays.Easy;

import java.util.Scanner;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array : ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }


        // Time complexity = O(N)
        // Space Complexity = O(1)
        int maxCount = 0;
        int count = 0;

        for(int i=0; i<size; i++) {
            if(arr[i] == 1) {
                count++;
                if(count > maxCount) {
                    maxCount = count;
                }
            } else {
                count = 0;
            }
        }

        System.out.println("Maximum consecutive ones in given array are: " + maxCount + ".");

        sc.close();
    }
}