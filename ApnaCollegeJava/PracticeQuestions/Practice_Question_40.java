// Print all permutations of a string.
// "abc"
// Permutations -> all possible combinations

// Time Complexity - O(n*n!) , n is string length

public class Practice_Question_40 {
    public static void printPermutation(String str, String Permutation) {
        if(str.length() == 0) {
            System.out.println(Permutation);
            return;
        }

        for(int i=0; i<str.length(); i++) {
            char currChar = str.charAt(i);

            // "abc" -> "ab"
            String newStr = str.substring(0, i) + str.substring(i+1);
            printPermutation(newStr, Permutation+currChar);
        }
    }
    public static void main(String args[]) {
        String str = "abc";
        printPermutation(str, "");
    }
}
