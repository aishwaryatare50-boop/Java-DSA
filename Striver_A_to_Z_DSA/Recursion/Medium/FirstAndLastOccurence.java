package Striver_A_to_Z_DSA.Recursion.Medium;

public class FirstAndLastOccurence {

    // Time Complexity = O(N)
    // Space Complexity = O(N) -> Recursion Stack
    public static void findOccurence(String str, char ch, int index, int first, int last) {
        if(index == str.length()) {
            System.out.println("First Occurence: " + first);
            System.out.println("Last Occurence: " + last);
            return;
        }

        if(str.charAt(index) == ch) {
            if(first == -1) {
                first = last = index;
            } else {
                last = index;
            }
        }

        findOccurence(str, ch, index + 1, first, last);
    }

    public static void main(String[] args) {
        findOccurence("abcaabcda", 'a', 0, -1, -1);
    }
}