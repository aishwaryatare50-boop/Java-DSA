package Recursions;

public class ReverseArray {
    public static void displayArray(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static int[] reverseArray(int arr[], int i) {
        if(i >= arr.length/2) {
            return arr;
        }

        int temp = arr[i];
        arr[i] = arr[arr.length - i - 1];
        arr[arr.length - i - 1] = temp;
        return reverseArray(arr, i+1);
    }
    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 4, 5};
        displayArray(arr);
        System.out.println();
        System.out.println("Reverse of arr is : ");
        reverseArray(arr, 0);
        displayArray(arr);
    }
}