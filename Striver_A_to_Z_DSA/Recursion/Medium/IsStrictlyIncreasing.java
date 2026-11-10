package Striver_A_to_Z_DSA.Recursion.Medium;

public class IsStrictlyIncreasing {

    // Time Complexity = O(N)
    // Space Complexity = O(N) -> Recursion Stack
    public static boolean isStrictlyIncreasing(int[] arr, int index) {
        if(index == arr.length - 1) return true;

        if(arr[index] < arr[index + 1]) return isStrictlyIncreasing(arr, index + 1);
        else return false;
    }
    
    public static void main(String[] args) {
        System.out.println(isStrictlyIncreasing(new int[] {1, 2, 2, 4, 5}, 0));
    }
}