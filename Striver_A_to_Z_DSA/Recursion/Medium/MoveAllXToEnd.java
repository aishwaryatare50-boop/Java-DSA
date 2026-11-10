package Striver_A_to_Z_DSA.Recursion.Medium;

public class MoveAllXToEnd {

    // Time Complexity = O(n) where n is the length of the string
    // Space Complexity = O(n) // auxilary recursion stack space
    public static String moveAllXToEnd(String str, int index, int countX, StringBuilder newStr)  {
        if(index == str.length()) {
            for(int i=0; i<countX; i++) {
                newStr.append('x');
            }

            return newStr.toString();
        }

        char ch = str.charAt(index);
        if(ch == 'x') {
            countX++;
        } else {
            newStr.append(ch);
        }

        return moveAllXToEnd(str, ++index, countX, newStr);
    }

    public static void main(String[] args) {
        System.out.println(moveAllXToEnd("axxbxvjkkgjaaxx", 0, 0, new StringBuilder()));
    }
}