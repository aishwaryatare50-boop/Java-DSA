package Extra_Questions;
// Write a program to implement bubble sort

import java.util.*;

public class Extra_Question_11 {
    public static Scanner sc = new Scanner(System.in);

    public static void displayArray(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int[] inputArray(int arr[]) {
        System.out.println("Enter elements of array : ");
        for(int i=0; i<arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }
    
    public static void main(String[] args) {
        System.out.print("Enter size of array : ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        inputArray(arr);
        System.out.println("Array before sorting is : ");
        displayArray(arr);

        boolean swapped = false;

        // ascending order
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j< arr.length-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }

            if(!swapped) {
                break;
            }
        }

        System.out.println("Array after bubble sort in ascending order : ");
        displayArray(arr);

        // decending order
        swapped = false;

        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr.length-1-i; j++) {
                if(arr[j] < arr[j+1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }

            if(!swapped) {
                break;
            }
        }

        System.out.println("Array after bubble sort in decending order : ");
        displayArray(arr);
    }
}