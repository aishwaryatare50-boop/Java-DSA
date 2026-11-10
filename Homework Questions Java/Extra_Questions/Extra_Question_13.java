package Extra_Questions;
// Create an array of arrays

public class Extra_Question_13 {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {6,7,8,9,10};
        int[] arr3 = {11,12,13,14,15};

        int[][] arr = {arr1, arr2, arr3};

        System.out.println(arr[0][0]);

        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<5; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
