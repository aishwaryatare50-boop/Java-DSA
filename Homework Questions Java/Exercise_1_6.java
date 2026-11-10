/* Write an infinite loop using do while condition. */

import java.util.*;

public class Exercise_1_6 {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Enter number : ");
            
            float n = sc.nextFloat();

            System.out.println("Square of entered number is : " + n*n);

            if(n == 0) {
                break;
            }
        } while(true) ;

        sc.close();
    }
}
