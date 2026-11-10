// Check if an array is sorted (Strictly Increasing)
// {1,2,3,4,5} = true
// {1,2,3,4,4} = false


// Time Complexity = O(n), here n = length of array
public class Practice_Question_34 {

    public static boolean isSorted(int arr[], int index) {
        if(index == arr.length-1) {
            return true;
        }

        if(arr[index] >= arr[index+1]) {
            // array is sorted till now 
            return false;
        } else {
            return isSorted(arr, index+1); 
        }
    }
    public static void main(String args[]) {
        int arr[] = {1, 2, 8, 4, 5};

        System.out.println(isSorted(arr, 0));
    }
}
