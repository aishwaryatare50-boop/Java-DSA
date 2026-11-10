/* Enter 3 numbers from the user & make a function to print their average. */

import java.util.*;

public class Exercise_1_1 {

    public static float average(float a, float b, float c) {
        return (a + b + c)/3;
    }

    public static void main(String args[]) {
        System.out.print("Enter 1st number : ");
        Scanner sc = new Scanner(System.in);
        float a = sc.nextFloat();

        System.out.print("Enter 2nd number : ");
        float b = sc.nextFloat();

        System.out.print("Enter 3rd number : ");
        float c = sc.nextFloat();

        System.out.println("The average of "+ a + ", " + b + " and " + c + " is : " + average(a,b,c));

        sc.close();
    }
}
