// Print all the possible combination of a string. repition of characters is allowed.

package Striver_A_to_Z_DSA.Recursion.Hard;

public class PrintCombination {

    // Time Complexity = O(n ^ n)
    // Space Complexity = O(n) // recursion stack space
    public static void printCombination(String str, StringBuilder combination) {
        if(str.length() == combination.length()) {
            System.out.println(combination);
            return;
        }

        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);

            printCombination(str, combination.append(ch));
            combination.deleteCharAt(combination.length() - 1);
        }
    }

    public static void main(String[] args) {
        printCombination("abc", new StringBuilder());
    }
}