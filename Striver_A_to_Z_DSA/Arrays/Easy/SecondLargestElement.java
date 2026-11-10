package Striver_A_to_Z_DSA.Arrays.Easy;

import java.util.Scanner;
import java.util.Arrays;

public class SecondLargestElement {

    // Time Complexity = O(NlogN)
    public static int bruteApproach(int[] arr) {
        int secondLargest = Integer.MIN_VALUE;

        Arrays.sort(arr);
        int largest = arr[arr.length - 1];

        for(int i=arr.length - 2; i>=0; i--) {
            if(arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }
        }

        return secondLargest;
    }

    // Time Complexity = O(N + N)
    public static int betterApproach(int[] arr) {
        int secondLargest = Integer.MIN_VALUE;

        int largest = arr[0];
        for(int i=1; i<arr.length; i++) {
            if(arr[i] > largest) {
                largest = arr[i];
            }
        }

        for(int i=0; i<arr.length; i++) {
            if(arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }
        }

        return secondLargest;
    }

    // Time Complexity = O(N)
    public static int optimalApproach(int[] arr) {
        int secondLargest = Integer.MIN_VALUE;

        int largest = arr[0];
        for(int i=0; i<arr.length; i++) {
            if(arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if(arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }

        return secondLargest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array : ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }

        int secondLargest = bruteApproach(arr);

        if(secondLargest == Integer.MIN_VALUE) {
            System.out.println("Second largest element doesn't exist in array.");
        } else {
            System.out.println("Second largest element of array is " + secondLargest + ".");
        }

        secondLargest = betterApproach(arr);

        if(secondLargest == Integer.MIN_VALUE) {
            System.out.println("Second largest element doesn't exist in array.");
        } else {
            System.out.println("Second largest element of array is " + secondLargest + ".");
        }

        secondLargest = optimalApproach(arr);

        if(secondLargest == Integer.MIN_VALUE) {
            System.out.println("Second largest element doesn't exist in array.");
        } else {
            System.out.println("Second largest element of array is " + secondLargest + ".");
        }
        
        sc.close();
    }
}