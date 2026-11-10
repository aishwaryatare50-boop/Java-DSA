package Striver_A_to_Z_DSA.Recursion.Medium;

public class PrintKeypadCombination {

    // Time Complexity: O(4^n) where n is the length of the input string. In the worst case, each digit can map to 4 letters (like 7 and 9), leading to 4^n combinations.
    // Space Complexity: O(n) for the recursion stack, where n is the length of the input string.
    public static void printKeypadCombination(String str, int index, String combination, String[] keypad) {
        if(index == str.length()) {
            System.out.println(combination);
            return;
        }

        char currentChar = str.charAt(index);
        String mapping = keypad[currentChar - '0'];

        for(int i=0; i<mapping.length(); i++) {
            printKeypadCombination(str, index + 1, combination + mapping.charAt(i), keypad);
        }
    }

    public static void main(String[] args) {
        String[] keypad = {".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

        String str = "23";
        printKeypadCombination(str, 0, "", keypad);
    }    
}