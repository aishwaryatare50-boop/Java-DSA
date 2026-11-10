package Extra_Questions;
// WAP to merge two arrays

import java.util.*;

public class Extra_Question_12 {
    public static Scanner sc = new Scanner(System.in);

    public static int[] inputArray(int arr[]) {
        System.out.println("Enter elements of array : ");
        for(int i=0; i<arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }
    public static void main(String[] args) {
        System.out.print("Enter size of first array : ");
        int size1 = sc.nextInt();
        System.out.print("Enter size of second array : ");
        int size2 = sc.nextInt();

        int[] arr1 = new int[size1];
        int[] arr2 = new int[size2];
        int[] arr = new int[size1 + size2];

        inputArray(arr1);
        inputArray(arr2);

        for(int i=0; i<arr1.length; i++) {
            arr[i] = arr1[i];
        }
        for(int i=arr1.length, j=0; i<arr.length && j<arr2.length; i++, j++) {
            arr[i] = arr2[j];
        }

        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
