package Recursions;

public class MaximumAndMinimumInArray {

    public static int maxmimum(int arr[], int idx, int max) {
        if(idx == arr.length) {
            return max;
        }

        if(max < arr[idx]) {
            max = arr[idx]; 
        }
        return maxmimum(arr, idx+1, max);
    }
    public static int minimum(int arr[], int idx, int min) {
        if(idx == arr.length) {
            return min;
        }
        if(min > arr[idx]) {
            min = arr[idx];  
        }
        return minimum(arr, idx+1, min);
    }
    public static void main(String args[]) {
        int arr[] = {1, 34, 56, 78, 89, 36, 100, -34, -12, 8, -45, 67};
        System.out.println("Maximum element in given array is : " + maxmimum(arr, 0, Integer.MIN_VALUE));
        System.out.println("Minimum element in given array is : " + minimum(arr, 0, Integer.MAX_VALUE));
    }
}
