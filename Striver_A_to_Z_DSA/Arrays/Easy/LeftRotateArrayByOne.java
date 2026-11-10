package Striver_A_to_Z_DSA.Arrays.Easy;

import java.util.Scanner;

public class LeftRotateArrayByOne {

    public static void printArray(int[] arr) {
        for(int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array : ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }

        int temp = arr[0];
        for(int i=0; i<size-1; i++) {
            arr[i] = arr[i+1];
        }
        arr[size-1] = temp;

        printArray(arr);

        sc.close();
    }
}