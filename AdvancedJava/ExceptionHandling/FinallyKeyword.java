package AdvancedJava.ExceptionHandling;

public class FinallyKeyword {

    public static int greet() {
        try {
            int a = 5;
            int b = 0;
            return a / b;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("This is end of function.");
        }

        return -1;

    }
    public static void main(String[] args) {
        System.out.println(greet());

        try {
            greet();
        } finally {
            System.out.println("End of program.");
        }
    }
}