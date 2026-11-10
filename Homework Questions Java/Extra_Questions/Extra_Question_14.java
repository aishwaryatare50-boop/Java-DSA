package Extra_Questions;
// WAP to swap first half of an array with second half
// [1, 2, 3, 4, 5, 6] = [4, 5, 6, 1, 2, 3]

import java.util.Scanner;

public class Extra_Question_14 {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter size of array : ");
        int size = sc.nextInt();
        int[] arr = new int[size];

        // input array
        System.out.println("Enter elements : ");
        for(int i=0; i<arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        // swap first half with second
        int leaveMiddle = 0;
        if(arr.length % 2 != 0) {
            leaveMiddle = 1;
        } 
        for(int i=0; i<arr.length/2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length/2 + leaveMiddle + i];
            arr[arr.length/2 + i + leaveMiddle] = temp;
        }

        // display
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
