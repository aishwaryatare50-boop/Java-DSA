/*
 * 3. Make a menu driven program. The user can enter 2 numbers, either 1 or 0.  
If the user enters 1 then keep taking input from the user for a student’s 
marks(out of 100).  
If they enter 0 then stop. 
If he/ she scores : 
Marks >=90 -> print “This is Good” 
89 >= Marks >= 60 -> print “This is also Good” 
59 >= Marks >= 0 -> print “This is Good as well” 
Because marks don’t matter but our effort does. 
(Hint : use do-while loop but think & understand why) 
 */

import java.util.*;

public class Lecture_4_3 {
    public static void main(String args[]) {        
        Scanner sc = new Scanner(System.in);
        int n;

        do {
            System.out.print("Enter choice : ");
            n = sc.nextInt();
            if(n==1) {
                System.out.print("Enter marks : ");
                int marks = sc.nextInt();
                if(marks <= 100 && marks >=0) {
                    if(marks >= 90) {
                        System.out.println("This is Good");
                    } else if(marks >= 60) {
                        System.out.println("This is also Good");
                    } else {
                        System.out.println("This is Good as well");
                    }
                } else {
                    System.out.println("Please enter  valid marks !");
                }
            } else if(n !=0) {
                System.out.println("Please enter valid choice !");
                n = 1;
            } else {
                break;
            }
        } while (n==1);

        sc.close();
    }
}