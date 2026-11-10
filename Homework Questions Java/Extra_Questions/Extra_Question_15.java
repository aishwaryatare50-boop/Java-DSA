package Extra_Questions;
// WAP to swap numbers in pairs in an array.
// [1, 2, 3, 4, 5, 6] = [2, 1, 4, 3, 6, 5]
// [1, 2, 3, 4, 5] = [2, 1, 4, 3, 5]

import java.util.Scanner;

public class Extra_Question_15 {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter size of arary : ");
        int size = sc.nextInt();

        int[] arr = new int[size];

        // input
        System.out.println("Enter elements : ");
        for(int i=0; i<arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        // swap in pairs
        for(int i=0; i<arr.length-1; i += 2) {
            int temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;
        }

        // output
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
