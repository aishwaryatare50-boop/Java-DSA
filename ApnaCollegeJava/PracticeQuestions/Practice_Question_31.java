// Tower of Hanoi/ Brahma/ Benares 

// Time Complexity => O(2^n - 1) = O(2^n)

import java.util.*;

public class Practice_Question_31 {
    
    public static void towerOfHanoi(int n, String source, String helper, String destination) {
        if(n == 1) {
            System.out.println("Transfer disk " + n + " from " + source + " to " + destination );
            return;
        }

        towerOfHanoi(n - 1, source, destination, helper);
        System.out.println("Transfer disk " + n + " from " + source + " to " + destination );
        towerOfHanoi(n - 1, helper, source, destination);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of disks : ");
        int n = sc.nextInt();
        towerOfHanoi(n, "S", "H", "D");

        sc.close();
    }
}