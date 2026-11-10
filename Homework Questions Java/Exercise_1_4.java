/* Write a function that takes in the radius as input and returns the circumference of a circle. */ 

import java.util.*;

public class Exercise_1_4 {
    public static void circumference(float r) {
        System.out.println("The circumference of circle of radius " + r + " is : " + 2*3.14*r);
    }

    public static void main(String args[]) {
        System.out.print("Enter radius : ");
        Scanner sc = new Scanner(System.in);
        float r = sc.nextFloat();

        circumference(r);

        sc.close();
    }
}
