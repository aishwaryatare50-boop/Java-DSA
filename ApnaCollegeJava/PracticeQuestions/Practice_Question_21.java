/* Make a function to multiply 2 numbers and return the product.
 */

import java.util.*;

public class Practice_Question_21 {
    public static int product(int a, int b) {
        return a*b;
    }

    public static void main(String args[]) {
        System.out.print("Enter a : ");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        System.out.print("Enter b : ");
        int b = sc.nextInt();

        System.out.println("The product is : " + product(a,b));

        sc.close();
    }
}
