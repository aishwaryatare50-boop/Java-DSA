package Extra_Questions;
// Check if a number has even number of digits.

import java.util.*;

public class Extra_Question_6 {
    public static void main(String args[]) {
        System.out.print("Enter number : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String number = Integer.toString(n);

        if(number.length() % 2 == 0) {
            System.out.println(n + " has even number of digits.");
        }

        sc.close();
    }
}
