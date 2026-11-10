package Recursions;

import java.util.*;

public class GCDofArray {
    public static Scanner sc = new Scanner(System.in);

    public static void inputArray(int arr[]) {
        System.out.println("Enter elements : ");
        for(int i=0; i<arr.length; i++) {
            arr[i] = sc.nextInt();
        }
    }

    public static int GCD(int a, int b) {
        if(b == 0) {
            return a;
        }

        return GCD(b, a % b);
    }
    public static int GCDOfArray(int arr[], int i, int currentGCD) {
        if(arr.length == 1) {
            return arr[0];
        }

        if(i == arr.length) {
            return currentGCD;
        }

        currentGCD = GCD(currentGCD,arr[i]);
        return GCDOfArray(arr, i+1, currentGCD);
    }
    public static void main(String args[]) {  
        System.out.print("Enter size of array : ");
        int size = sc.nextInt();
        int arr[] = new int[size];

        inputArray(arr);

        System.out.println("GCD of given array is : " + GCDOfArray(arr, 0, arr[0]));
    }
}
