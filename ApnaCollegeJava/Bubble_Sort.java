public class Bubble_Sort {

    public static void printArray(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String args[]) {
        int arr[] = {7, 8, 3, 1, 2};

        // BUBBLE SORT =  n-1 comparisons 
        // time complexity = O(n^2)
        
        // Ascending order
        for(int i=0; i<arr.length -1; i++) { // n-1

            boolean isSwap = false;

            for(int j=0; j<arr.length-i-1; j++) { // here we have optimised the algorithm
                if(arr[j] > arr[j+1]) {
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    isSwap = true;
                }
            }

            if(!isSwap) { // array is already sorted
                return;
            }
        }

        printArray(arr);

        // Decending order
        for(int i=0; i<arr.length-1; i++) {
            for(int j=0; j<arr.length-i-1; j++) {
                if(arr[j] < arr[j+1] ) {
                    // swap
                    arr[j] = arr[j] ^ arr[j+1];
                    arr[j+1] = arr[j] ^ arr[j+1];
                    arr[j] = arr[j] ^ arr[j+1];
                }
            }
        }

        printArray(arr);
    }
}