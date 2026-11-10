package Recursions;

// two words are anagram if they have exactly same characters and length.
import java.util.*;

public class CheckAnagram {
    public static boolean checkAnagram(String str1, String str2) {
        if(str1.length() != str2.length()) {
            return false;
        }
        if(str1.length() == 0 && str2.length() == 0) return true;

        char ch = str1.charAt(0);

        int idx = str2.indexOf(ch);

        if(idx == -1) return false;

        String newStr1 = str1.substring(1);
        String newStr2 = str2.substring(0,idx) + str2.substring(idx+1, str2.length());

        return checkAnagram(newStr1, newStr2);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string : ");
        String str1 = sc.next();
        System.out.print("Enter second string : ");
        String str2 = sc.next();

        System.out.println(checkAnagram(str1, str2));
        
        sc.close();
    }
}
