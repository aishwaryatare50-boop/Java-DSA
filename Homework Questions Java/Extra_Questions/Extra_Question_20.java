// Check if an array is sorted (strictly increasing)
// 1, 2, 3, 5 - correct
// 1, 2, 4, 4, 5 - incorrect

package Extra_Questions;

public class Extra_Question_20 {
    public static boolean isSorted(int[] arr, int idx) {
        if(idx == arr.length-1) {
            return true;
        }
        if(arr[idx] >= arr[idx+1]) {
            return false;
        }
        return isSorted(arr, idx+1);
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 4};
        System.out.println(isSorted(arr, 0));
    
    }
}