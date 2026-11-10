// WAP to reverse a string
 
package Extra_Questions;

import java.util.Scanner;

public class Extra_Question_18 {
    public static StringBuilder reverseString(StringBuilder sb, int idx) {
        if(idx == sb.length()/2) {
            return sb;
        }

        char temp = sb.charAt(idx);
        sb.setCharAt(idx, sb.charAt(sb.length()-idx-1));
        sb.setCharAt(sb.length()-idx-1, temp);

        return reverseString(sb, idx+1);
    }
    public static void main(String[] args) {
        System.out.print("Enter string : ");
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder(str);
        System.out.println(sb);
        sb = reverseString(sb, 0);
        System.out.println(sb);

        sc.close();
    }
}
