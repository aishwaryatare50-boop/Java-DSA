package Striver_A_to_Z_DSA.Arrays.Easy;

import java.util.Scanner;

public class RightRotateArrayByOne {

    public static void printArray(int[] arr) {
        for(int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array : ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }

        int temp = arr[size-1];
        for(int i=size-2; i>=0; i--) {
            arr[i+1] = arr[i];
        }
        arr[0] = temp;
        printArray(arr);

        sc.close();
    }    
}