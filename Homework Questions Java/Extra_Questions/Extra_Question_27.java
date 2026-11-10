// WAP to implement binary search

package Extra_Questions;

import java.util.Scanner;

public class Extra_Question_27 {
    public static void main(String[] args) {
        System.out.print("Enter size of array(Please ensure input is sorted) : ");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        int[] arr = new int[size];

        for(int i=0; i<arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter element to be searched : ");
        int k = sc.nextInt();

        long t1 = System.currentTimeMillis();

        int begin = 0;
        int end = arr.length-1;

        while(end-begin > 1) {
            int mid = (begin+end)/2;

            if(arr[mid] == k) {
                System.out.println("Element found!");
                break;
            }

            if(k < arr[mid]) {
                end = mid-1;
            }

            if(k > arr[mid]) {
                begin = mid+1;
            }
        }

        if(arr[end] == k || arr[begin] == k) {
            System.out.println("Element found!");
        }

        long t2 = System.currentTimeMillis();

        System.out.println(t2-t1);

        sc.close();
    }
}
