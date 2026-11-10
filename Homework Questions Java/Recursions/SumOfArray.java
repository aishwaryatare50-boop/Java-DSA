package Recursions;

public class SumOfArray {
    // helper function
    public static int printSumOfArrayHelper(int arr[], int idx) {
        if(idx == arr.length) {
            return 0;
        }
        return arr[idx] + printSumOfArrayHelper(arr, idx+1);
    }
    // wrapping
    public static void printSumOfArray(int arr[]) {
        System.out.println("Sum of given array is : " + printSumOfArrayHelper(arr, 0));
    }

    public static void main(String args[]) {
        int arr[] = {23, 45, 56, 78, 89};
        printSumOfArray(arr);
    }
}