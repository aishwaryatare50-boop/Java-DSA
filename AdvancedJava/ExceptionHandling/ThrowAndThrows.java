package AdvancedJava.ExceptionHandling;

class NegativeRadiusException extends Exception {
    public String toString() {
        return "Radius cannot be negative";
    }

    public String getMessage() {
        return "Radius cannot be negative";
    }
}


public class ThrowAndThrows {

    public static double circleArea(int r) throws NegativeRadiusException {
        if(r < 0) {
            throw new NegativeRadiusException();
        }

        return Math.PI * r * r;
    }

    public static int divide(int a, int b) throws ArithmeticException {
        return a / b;
    }

    public static void main(String[] args) {
        try {
            System.out.println(divide(6, 0));
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            double area = circleArea(-4);
            System.out.println(area);
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("End of program");
    }
}