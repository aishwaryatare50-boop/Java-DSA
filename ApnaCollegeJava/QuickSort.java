public class QuickSort {

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for(int j=low; j<high; j++) {
            if(arr[j] < pivot) {
                i++;
                // swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        // swapping pivot on its correct position
        int temp = arr[i];
        arr[i] = pivot;
        arr[high] = temp;
        
        return i; // pivot index
    }

    public static void quickSort(int[] arr, int low, int high) {
        if(high-low > 0) {
            int pidx = partition(arr, low, high);

            quickSort(arr, low, pidx-1);
            quickSort(arr, pidx+1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, 9, 5, 2, 8};
        int n = arr.length;

        // Average case time complexity = O(nlogn)
        // Worst case time complexity = O(n^2)
        quickSort(arr, 0, n-1);

        //print
        for(int i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
