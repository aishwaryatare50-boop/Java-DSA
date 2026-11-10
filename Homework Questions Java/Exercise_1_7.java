/* Write a program to enter the numbers till the user wants and at the end it 
should display the count of positive, negative and zeros entered. */


import java.util.*;

public class Exercise_1_7 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int a = 0, b = 0, c = 0;

        do{
            System.out.print("Enter number : ");
            int n = sc.nextInt();

            if(n>0) {
                a++;
            } else if(n<0) {
                b++;
            } else {
                c++;
            }

            if(n == 101) {
                break;
            }

        } while(true);

        System.out.println("You entered " + a + " positive numbers, " + b + " negative numbers and " + c + " zeroes.");

        sc.close();
    }
}
