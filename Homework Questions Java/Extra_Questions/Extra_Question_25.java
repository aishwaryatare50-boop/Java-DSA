// Write a program to print all the permutations of a string

package Extra_Questions;

public class Extra_Question_25 {
    public static void printCombination(String str, String permutation) {
        if(str.length() == 0) {
            System.out.println(permutation);
            return;
        }

        for(int i=0; i<str.length(); i++) {
            printCombination(str.substring(0, i)+str.substring(i+1),permutation+str.charAt(i));
            
        }

    }
    public static void main(String[] args) {
        String str = "abc";
        printCombination(str, "");
    }
}
