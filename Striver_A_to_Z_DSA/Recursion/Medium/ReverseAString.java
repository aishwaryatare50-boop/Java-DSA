package Striver_A_to_Z_DSA.Recursion.Medium;

public class ReverseAString {

    // Time Complexity = O(N)
    // Space Complexity = O(N) -> Recursion Stack
    public static void reverseString(String str, int index) {
        if(index == 0) {
            System.out.println(str.charAt(index));
            return;
        }

        System.out.print(str.charAt(index));
        reverseString(str, index - 1);
    }

    public static void main(String[] args) {
        reverseString("Hello World", 10);
    }
}