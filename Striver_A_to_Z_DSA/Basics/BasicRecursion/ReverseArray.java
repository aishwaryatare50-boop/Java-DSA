package Striver_A_to_Z_DSA.Basics.BasicRecursion;

public class ReverseArray {

    private static int[] helper(int[] arr, int i) {
        if(i >= arr.length / 2) {
            return arr;
        }

        int temp = arr[i];
        arr[i] = arr[arr.length - i - 1];
        arr[arr.length - i - 1] = temp;

        return helper(arr, i+1);
    }

    public static int[] reverseArray(int[] arr) {
        return helper(arr, 0);
    }

    public static void displayArray(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int[] reverseArray2(int[] arr, int l, int r) {
        // Two pointer approach
        if(l >= r) {
            return arr;
        }

        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;

        return reverseArray2(arr, l+1, r-1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        displayArray(arr);
        arr = reverseArray(arr);
        displayArray(arr);

        arr = reverseArray2(arr, 0, arr.length-1);
        displayArray(arr);
    }
}