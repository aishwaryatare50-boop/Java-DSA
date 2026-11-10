import java.util.*;

class Input_and_Output {

    public static void main(String args[]) {
        // Input
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        // Output
        System.out.println(name);

        // next() is used for single token input
        // nextline() is used for many tokens input
        // nextInt() is used for integer input
        // nextFloat() is used for float input
        // also nextDouble() and nextLong() are used for respective datatype 

        sc.close();
    }
}
