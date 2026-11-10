// Print all even numbers till n.

import java.util.*;

public class Lecture_4_1 {
    public static void main(String args[]) {
        System.out.print("Enter number : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println("All the even numbers till "+ n + " are : ");

        for(int i = 0; i <= n; i++ ) {
            if(i % 2 == 0 ) {
                System.out.print(i+"  ");
            }
        }

        sc.close();
    }
}
