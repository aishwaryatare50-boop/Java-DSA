package Extra_Questions;
// Write a program to perform creation, insertion, deletion and traversal operation on array using functions.

import java.util.*;

public class Extra_Question_4 {
    public static Scanner sc = new Scanner(System.in);

    public static int[] createArray(int size) {
        return new int[size];
    }

    public static void traverseArray(int arr[], int n) {
        for(int i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int insertElement(int arr[], int n, int element, int position) {
        if (n == arr.length) {
            System.out.println("Insertion not possible, array is full.");
            return n;
        }
        if (position < 1 || position > n + 1) {
            System.out.println("Invalid position!");
            return n;
        }

        for(int i=n-1; i>=position-1; i--) {
            arr[i+1] = arr[i];
        }
        arr[position-1] = element;
        return n + 1;
    }

    public static int deleteElement(int arr[], int n, int location) {
        if (location < 1 || location > n) {
            System.out.println("Invalid location!");
            return n;
        }
        
        for(int i=location-1; i< n-1; i++) {
            arr[i] = arr[i+1];
        }
        return n - 1;
    }

    public static void main(String args[]) {
        System.out.print("Enter size of array : ");
        int size = sc.nextInt();

        // Creation
        int arr[] = createArray(size);

        System.out.print("Enter number of elements to be inserted : ");
        int n = sc.nextInt();
        for(int i=0; i<n; i++) {
            System.out.print("Enter " + (i+1) +  " element : ");
            arr[i] = sc.nextInt();
        }
        // Traversal
        traverseArray(arr, n);

        // Insertion
        System.out.print("Enter element to be inserted : ");
        int element = sc.nextInt();
        System.out.print("Enter position at which " + element + " needs to be inserted : ");
        int position = sc.nextInt();

        n = insertElement(arr, n, element, position);
        traverseArray(arr, n);

        // Deletion
        System.out.print("Enter location whose element needs to be deleted : ");
        int location = sc.nextInt();

        n = deleteElement(arr, n, location);
        traverseArray(arr, n);

    }
}