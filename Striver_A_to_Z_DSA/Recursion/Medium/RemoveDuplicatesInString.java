package Striver_A_to_Z_DSA.Recursion.Medium;

public class RemoveDuplicatesInString {

    public static void removeDuplicates(String str, int index, StringBuilder newStr, boolean[] map) {
        if(index == str.length()) {
            System.out.println(newStr);
            return;
        }

        char ch = str.charAt(index);
        if(map[ch - 'a']) {
            removeDuplicates(str, ++index, newStr, map);
        } else {
            newStr.append(ch);
            map[ch - 'a'] = true;
            removeDuplicates(str, ++index, newStr, map);
        }
    }

    public static void main(String[] args) {
        removeDuplicates("abbacacca", 0, new StringBuilder(), new boolean[25]);
    }
}