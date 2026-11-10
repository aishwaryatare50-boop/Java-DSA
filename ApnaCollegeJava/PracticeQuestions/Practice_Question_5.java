/* Print the greeting 
 * 1 -> Hello
 * 2 -> Namaste
 * 3 -> Bonjour
 */

import java.util.*; 

public class Practice_Question_5 {
    public static void main(String args[]) {

        System.out.print("Enter choice : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if( n == 1 || n == 2 || n ==3 ) {
            if(n==1) {
                System.out.println("Hello !! ");
            } else if(n==2) {
                System.out.println("Namaste !!");
            } else {
                System.out.println("Bonjour !!");
            }
        } else {
            System.out.println("*Please enter valid option*");
        }

        // or we can also code efficiently
        /* 
         * This code is more efficient than above one
         * since in this code we are checking only one
         * condition but in above one we are checking 
         * two conditions it does not matter much for
         * now but will matter in long codes.
         */
        
        System.out.print("Enter button : ");
        int button = sc.nextInt();

        if(button == 1) {
            System.out.println("----Hello----");
        } else if(button == 2) {
            System.out.println("----Namaste----");
        } else if(button == 3) {
            System.out.println("----Bonjour----");
        } else {
            System.out.println("Invalid button !");
        }

        sc.close();

    }
}
