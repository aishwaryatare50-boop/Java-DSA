package Striver_A_to_Z_DSA.Arrays.Easy;

import java.util.Scanner;

public class RightRotateArrayByK {

    public static void printArray(int[] arr) {
        for(int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    // approach - 1
    public static void approach1(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        int[] temp = new int[k];
        for(int i=n-k; i<n; i++) {
            temp[i - (n-k)] = arr[i];
        }

        for(int i=n-k-1; i>=0; i--) {
            arr[i+k] = arr[i];
        }

        for(int i=0; i<k; i++) {
            arr[i] = temp[i];
        }
    }

    // approach - 2
    public static void approach2(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        reverse(arr, 0, n-1);
        reverse(arr, 0, k-1);
        reverse(arr, k, n-1);
    }

    public static void reverse(int[] arr, int si, int ei) {
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

        System.out.print("Enter size of array : ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        // approach1(arr, k);
        // printArray(arr);

        approach2(arr, k);
        printArray(arr);

        sc.close();
    }    
}