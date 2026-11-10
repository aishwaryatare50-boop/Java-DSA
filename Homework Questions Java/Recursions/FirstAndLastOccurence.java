package Recursions;

public class FirstAndLastOccurence {
    // display array
    public static void displayArray(int[] arr, int idx){
        if(idx == arr.length) {
            return;
        }
        System.out.print(arr[idx] + "   ");
        displayArray(arr, idx+1);
        return;
    }

    public static void firstAndLastOccurenceHelper(int[] arr, int idx, int element, int firstOccurence, int lastOccurence) {
        if(idx == arr.length) {
            System.out.println(firstOccurence);
            System.out.println(lastOccurence);
            return; 
        }
        if(arr[idx] == element && firstOccurence != lastOccurence) {
            firstOccurence = idx+1;
            lastOccurence = firstOccurence;
        }
        if(arr[idx] == element) {
            lastOccurence = idx+1;
        }
        firstAndLastOccurenceHelper(arr, idx+1, element, firstOccurence, lastOccurence);
    }

    public static void firstAndLastOccurence(int[] arr, int element) {
        firstAndLastOccurenceHelper(arr, 0, element, -1, 0);
    }

    public static void main(String args[]) {
        int[] arr = {2, 4, 5, 2, 5, 7, 2, 7, 8, 9, 8, 2};
        firstAndLastOccurence(arr, 8);
    }
}
