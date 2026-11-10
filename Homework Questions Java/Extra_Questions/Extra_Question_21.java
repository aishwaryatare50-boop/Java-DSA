// Move all x to the end of string.
// abbxxcx = abbcxxx

package Extra_Questions;

public class Extra_Question_21 {
    public static String moveXtoEnd(String str, int idx, int count, String newStr) {

        if(idx == str.length()) {
            for(int i=0; i<count; i++) {
                newStr += 'x';
            }
            return newStr;
        }

        if(str.charAt(idx) == 'x') {
            count++;
        } else {
            newStr += str.charAt(idx);
        }

        return moveXtoEnd(str, idx+1, count, newStr);
    }

    // or we can also code 
    public static String moveXToEnd(String str, int idx) {
        if(idx == str.length()) {
            return "";
        }

        String newStr = moveXToEnd(str, idx+1);
        
        if(str.charAt(idx) == 'x') {
            return newStr + 'x';
        } else {
            return str.charAt(idx) + newStr;
        }
    }

    public static void main(String[] args) {
        String str = "axbbxcdxx";
        String newString = moveXtoEnd(str, 0, 0, "");
        System.out.println(newString);

        String newStr = moveXToEnd(str, 0);
        System.out.println(newStr);

    }
}
