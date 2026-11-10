package Extra_Questions;
/* Write a program to print the highest frequency character in a string. */

import java.util.*;

public class Extra_Question_2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string : ");
        String str = sc.nextLine();

        int highestFrequency = 0;
        char highChar  = ' ';

        for(int i=0; i<str.length(); i++) {
            int frequency = 1;

            if(str.charAt(i) == ' ') {
                continue;
            }

            for(int j=i+1; j<str.length(); j++) {

                if(str.charAt(i) == str.charAt(j)) {
                    frequency ++;
                }
            }

            if(frequency > highestFrequency) {
                highChar = str.charAt(i);
                highestFrequency = frequency;
            }
        }

        System.out.println("Highest frequency character in "+ "'" + str +"'" + " is " + highChar + " with a frequency of " + highestFrequency );

        sc.close();
    }
}
