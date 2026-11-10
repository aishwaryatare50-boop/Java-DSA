// Print the table of a number input by the user

import java.util.*;

public class Practice_Question_8 {
    public static void main(String args[]) {
        System.out.print("Enter number : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println("The table of "+ n +" is : ");

        for(int i = 1; i<=10; i++) {
            System.out.print(n*i+"  ");
        }

        sc.close();
    }
}
