/* 2.	Make a program that takes the radius of a circle as input,
calculates its radius and area and prints it as output to the user. */

import java.util.*;

class Lecture_2_2 {
    public static void main(String args[]) {

        System.out.print("Enter radius : ");
        Scanner sc = new Scanner(System.in); 
        float r = sc.nextFloat();

        float Area = (22*r*r)/ 7;

        System.out.print("Area of given circle is : ");
        System.out.print(Area);

        sc.close();
    }
}