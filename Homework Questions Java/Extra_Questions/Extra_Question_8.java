package Extra_Questions;
// Print student name, marks and subject using arrays.

import java.util.*;

public class Extra_Question_8 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String name[] = new String[5];
        String subject[] = new String[5];
        int marks[][] = new int[5][5];

        System.out.println("Enter subjects : ");
        for(int i=0; i<5; i++) {
            subject[i] = sc.next();
        }

        for(int i=0; i<5; i++) {
            System.out.print("Enter name : ");
            name[i] = sc.next();
            System.out.println("Enter marks : ");
            for(int j=0; j<5; j++) {
                marks[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<5; i++) {
            System.out.println(name[i]);
            for(int j=0; j<5; j++) {
                System.out.println(subject[j] + " : " + marks[i][j]);
            }
        }
        sc.close();
    }
}
