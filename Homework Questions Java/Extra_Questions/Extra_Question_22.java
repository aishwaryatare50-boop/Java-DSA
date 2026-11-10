// remove all duplicates in a string

package Extra_Questions;

public class Extra_Question_22 {
    public static boolean[] alpha = new boolean[26];

    public static String removeDuplicates(String str, int idx) {
        if(idx == str.length()) {
            return "";
        }

        char currChar = str.charAt(idx);

        if(alpha[currChar-'a']) {
            return removeDuplicates(str, idx+1);    
        } 

        alpha[str.charAt(idx)-'a'] = true;
        return currChar + removeDuplicates(str, idx+1);
        
    }

    public static void main(String[] args) {
        String str = "aawbabccz";
        System.out.println(removeDuplicates(str, 0));

    }
}
