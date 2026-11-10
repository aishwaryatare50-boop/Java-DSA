package AdvancedJava.ExceptionHandling;

public class HandlingSpecificException {
    public static void main(String[] args) {
        try {
            // code
        } catch (ArrayIndexOutOfBoundsException e) {
            // code
        } catch (ArithmeticException e) {
            // code
        } catch (Exception e) {
            // code
        }

        // nested try-catch

        try {
            // code
            try {
                // code
            } catch(Exception e) {
                // code
            }
        } catch(Exception e) {
            // code
        }
    }
}
