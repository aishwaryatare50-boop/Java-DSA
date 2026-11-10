package Recursions;

import java.util.*;

public class OccurencesOfCharacter {
    // helper function-1
    public static int occurencesOfCharacterHelper(String str, char ch, int idx, int count) {
        if(idx == str.length()) {
            return count;
        }
        if(str.charAt(idx) == ch) {
            count++;
        }
        return occurencesOfCharacterHelper(str, ch, idx+1, count);
    }
    // wrapping
    public static void occurencesOfCharacter(String str, char ch ) {
        System.out.println(ch + " occured in " + str + " " + occurencesOfCharacterHelper(str, ch, 0, 0) + " times.");
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        // input string
        System.out.print("Enter String : ");
        String str = sc.nextLine();
        // input character
        System.out.print("Enter character whose occurence need to be found : ");
        char ch  = sc.next().charAt(0);

        occurencesOfCharacter(str, ch);

        sc.close();
    }
}
