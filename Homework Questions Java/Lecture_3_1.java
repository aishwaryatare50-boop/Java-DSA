/* 
Make a Calculator. Take 2 numbers (a & b) from the user and an 
operation as follows :  
* 1 : + (Addition) a + b 
* 2 : - (Subtraction) a - b 
* 3 : * (Multiplication) a * b 
* 4 : / (Division) a / b 
* 5 : % (Modulo or remainder) a % b 
Calculate the result according to the operation given and 
display it to the user. 
 */

import java.util.*;

public class Lecture_3_1 {
    public static void main(String args[]) {
        System.out.print("Enter first number : ");
        Scanner sc = new Scanner(System.in);
        float a = sc.nextFloat();

        System.out.print("Enter second number : ");
        float b = sc.nextFloat();

        System.out.print("Enter operation : ");
        int opn = sc.nextInt();

            switch(opn) {
                case 1: System.out.println(a+b); // additon
                break;
                case 2: System.out.println(a-b); // subtraction
                break;
                case 3: System.out.println(a*b); // multiplication
                break;
                case 4: if(b==0) { // division
                           System.out.println("Invalid division");
                        } else {
                           System.out.println(a/b);
                        }
                break;
                case 5: if(b==0) {
                          System.out.println("Invalid division");
                        } else {
                          System.out.println(a%b); 
                         }    // remainder
                break;
                default : System.out.println("Invalid operator");
            }
            
        sc.close();
    }
    
}
