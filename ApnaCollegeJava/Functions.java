/* 1. Print a given name in a function. */

import java.util.*;

public class Functions {

    public static void printMyName(String name) { // fuction is declared
        System.out.println("Your name is : " + name); // function is defined
        return;
    }
    public static void main(String args[]) {
        System.out.print("Enter your name : ");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();

        printMyName(name);// fuction is called

        sc.close();
    }
}