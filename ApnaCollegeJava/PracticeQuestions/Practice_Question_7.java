// Print the sum of first n natural numbers.

import java.util.*;

public class Practice_Question_7 {
    public static void main(String args[]) {
        System.out.print("Enter n : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum=0;

        if(n>0) {
            for(int i=1; i<=n ; i++) {
                sum = sum +i;
            }
            System.out.println("Sum of first "+n+" natural number is : "+sum);
        } else {
            System.out.println("Please enter a natural number");
        }

        sc.close();
    }
    
}
