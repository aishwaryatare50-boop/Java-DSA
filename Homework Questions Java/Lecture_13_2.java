/* Input a string from the user. Create a new string called ‘result’ in which you will replace the letter ‘e’ in the original string with letter ‘i’. 
Example : 
original = “eabcdef’ ; result = “iabcdif”
Original = “xyz” ; result = “xyz”
 */

import java.util.*;

public class Lecture_13_2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string : ");
        String str = sc.nextLine();

        StringBuilder sb = new StringBuilder(str);

        for(int i=0; i<sb.length(); i++) {
            if(sb.charAt(i) == 'e') {
                sb.setCharAt(i, 'i');
            }
        }

        System.out.println(sb);

        sc.close();
    }
}
