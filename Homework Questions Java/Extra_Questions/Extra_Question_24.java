/* Print keypad combination.
 *  0 -> .
 *  1 -> abc
 *  2 -> def
 *  3 -> ghi
 *  4 -> jkl
 *  5 -> mno
 *  6 -> pqrs
 *  7 -> tu
 *  8 -> vwx
 *  9 -> yz
 */

// Time Complexity = O(4^n), n maximum length of string

package Extra_Questions;

public class Extra_Question_24 {
    public static String[] keypad = {".","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};

    public static void printKeypadCombination(String str, int idx, String combination) {

        if(idx == str.length()) {
            System.out.println(combination);
            return;
        }
        
        char currChar = str.charAt(idx);
        String mapping = keypad[currChar-'0'];

        for(int i=0; i<mapping.length(); i++) {
            printKeypadCombination(str, idx+1, combination + mapping.charAt(i));
        }
    }
    public static void main(String[] args) {
        String str = "12";
        printKeypadCombination(str, 0, "");
    }
}
