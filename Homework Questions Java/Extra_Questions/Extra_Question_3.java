package Extra_Questions;
// Make an array and perform insertion operation on it.

import java.util.*;

public class Extra_Question_3 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements to be entered : ");
        int n = sc.nextInt();

        int arr[] = new int[10];

        for(int i=0; i<n; i++) {
            System.out.print("Enter element for index " + i  + " : ");
            arr[i] = sc.nextInt();
        }

        for(int i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        System.out.print("Enter element to be inserted : ");
        int element = sc.nextInt();

        System.out.print("Enter the position at which " + element + " needs to be entered : ");
        int position = sc.nextInt();

        // here if position = 1 then it will be insertion at first

        for(int i=n - 1; i>= position-1; i--) {
            arr[i+1] = arr[i];
        }

        arr[position - 1] = element;

        for(int i=0; i<n+1; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}