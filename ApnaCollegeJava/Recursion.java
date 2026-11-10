public class Recursion {

    public static void printNumbers(int n) {
        if(n == 0) {
            return;
        }
        System.out.println(n); // print
        printNumbers(n-1); // recursion
    }

    public static void printNum(int m) {
        if(m == 6) {
            return;
        }
        System.out.println(m);
        printNum(m + 1);
    }

    public static void main(String args[]) {
        // Print numbers from 5 to 1

        int n = 5;
        printNumbers(n); // n=5

        // Print numbers from 1 to 5
        int m = 1;
        printNum(m); // n=1
    }
}
