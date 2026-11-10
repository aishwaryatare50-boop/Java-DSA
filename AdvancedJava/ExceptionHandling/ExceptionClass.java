package AdvancedJava.ExceptionHandling;

import java.util.Scanner;

class MyException extends Exception {
    public String toString() {
        return super.toString() + "I am toString";
    }

    public String getMessage() {
        return "I am getMessage";
    }
}

public class ExceptionClass {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        if(a < 9) {
            try {
                sc.close();
                throw new MyException();
                
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println(e.toString());
                System.out.println(e);
                e.printStackTrace();
            }
        }
    }    
}