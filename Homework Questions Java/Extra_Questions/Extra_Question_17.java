// WAP that implements bubble, insertion and selection sort on an array

package Extra_Questions;

import java.util.Scanner;

public class Extra_Question_17 {

    // declare scanner class for input
    public static Scanner sc = new Scanner(System.in);

    // input array
    public static int[] inputArray(int[] arr) {
        System.out.println("Enter elements : ");

        for(int i=0; i<arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        return arr;
    }

    // display array
    public static void displayArray(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // BUBBLE SORT
    // Best case time complexity = O(n) (in this case otherwise O(n^2))
    // Worst case time complexity = O(n^2)

    // a) ascending order
    public static int[] bubbleSortAscending(int[] arr) {
        boolean isSorted = true;
        // n-1 times loop
        for(int i=0; i<arr.length-1; i++) {
            // inner comparision of adjacent elements
            for(int j=0; j<arr.length-i-1; j++) {

                if(arr[j] > arr[j+1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    isSorted = false;
                }
            }
            if(isSorted) {
                break;
            }
        }

        return arr;
    }

    // b) descending order
    public static int[] bubbleSortDecending(int[] arr) {
        boolean isSorted = true;
        // n-1 times loop runs
        for(int i=0; i<arr.length-1; i++) {
            // comparisions
            for(int j=0; j<arr.length-i-1; j++) {
                if(arr[j] < arr[j+1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    isSorted = false;
                }
            }

            if(isSorted) {
                break;
            }
        }

        return arr;
    }

    // SELECTION SORT
    // Time complexity = O(n^2) in all cases best, worst, average

    // a) ascending order
    public static int[] selectionSortAscending(int[] arr) {
        for(int i=0; i<arr.length-1; i++) {
            int smallest = i;
            for(int j=i+1; j<arr.length; j++) {
                if(arr[j] < arr[smallest]) {
                    smallest = j;
                }
            }
            // swap
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
        }

        return arr;
    }

    // b) descending order
    public static int[] selectionSortDescending(int arr[]) {
        for(int i=0; i< arr.length-1; i++) {
            int largest = i;
            for(int j=i+1; j<arr.length; j++) {
                if(arr[j] > arr[largest]) {
                    largest = j;
                }
            }
            // swap
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
        }

        return arr;
    }

    // INSERTION SORT
    // Time complexity = O(n^2)  worst and average case and
    // O(n) in best case

    // ascending order
    public static int[] insertionSortAscending(int[] arr) {
        for(int i=1; i<arr.length; i++) {
            int current = arr[i];
            int j = i-1;
            while(j >= 0 && current < arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }

            // placement
            arr[j+1] = current;
        }
        return arr;
    }

    // descending order
    public static int[] insertionSortDecending(int[] arr) {
        for(int i=1; i<arr.length; i++) {
            int current = arr[i];
            int j = i-1;
            while(j >= 0 && current > arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = current;

        }
        return arr;
    }

    public static void main(String[] args) {
        
        System.out.print("Enter size of array : ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        arr = inputArray(arr);

        arr = bubbleSortAscending(arr);
        displayArray(arr);

        arr = bubbleSortDecending(arr);
        displayArray(arr);

        arr = selectionSortAscending(arr);
        displayArray(arr);

        arr = selectionSortDescending(arr);
        displayArray(arr);

        arr = insertionSortAscending(arr);
        displayArray(arr);

        arr = insertionSortDecending(arr);
        displayArray(arr);
    }
}
