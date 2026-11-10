/* Input a string from the user. Create a new string called ‘result’ in which you will replace the letter ‘e’ in the original string with letter ‘i’. 
Example : 
original = “eabcdef’ ; result = “iabcdif”
Original = “xyz” ; result = “xyz”
 */

import java.util.*;

public class Lecture_12_2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter String : ");
        String Original = sc.nextLine();

        String result = "";

        for(int i=0; i<Original.length(); i++) {
            if(Original.charAt(i) == 'e') {
                result += 'i';
            } else {
                result += Original.charAt(i);
            }
        }

        System.out.println(Original + "\n" + result);

        sc.close();
    }
}
