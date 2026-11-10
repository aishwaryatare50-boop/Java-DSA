import java.util.*;

public class Conditional_Statements_if_esle {
    public static void main(String args[]) {

        System.out.print("Enter age : ");

        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();

        if( age>= 18) {
            System.out.print("Is an Adult");
        } else {
            System.out.print("Not an Adult");
        }

        sc.close();
    } 
}
