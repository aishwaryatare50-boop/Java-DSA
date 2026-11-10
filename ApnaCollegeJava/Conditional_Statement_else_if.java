import java.util.*;

public class Conditional_Statement_else_if {
    public static void main(String arg[]) {

        System.out.print("Enter a : ");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        System.out.print("Enter b : ");
        int b = sc.nextInt();

        if( a>b ) {
            System.out.println("a is greater than b.");
        } else if( a<b ) {
            System.out.println("a is less than b.");
        } else {
            System.out.println("a is equal to b.");
        }

        sc.close();

    }    
}
