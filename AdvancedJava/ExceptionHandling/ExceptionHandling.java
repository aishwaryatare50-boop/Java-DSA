package AdvancedJava.ExceptionHandling;
public class ExceptionHandling {
    public static void main(String args[]) {
        // Exception Handling
        // TRY - CATCH in Exception Handling
        int[] marks = {97, 98, 95};
        System.out.println(marks[2]);

        try {
            System.out.println(marks[5]);
        } catch(Exception exception) {
            //do something after catching
            System.out.println("Enter valid index");
        }
        
        System.out.println("The name is Aman");
    }
}