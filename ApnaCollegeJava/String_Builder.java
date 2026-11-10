public class String_Builder {
    public static void main(String args[]) {
        // Declaration
        StringBuilder sb = new StringBuilder("Tony");
        System.out.println(sb);

        // Functions on StringBuilder : 

        // 1) charAt(i) = character at index i
        System.out.println(sb.charAt(0));

        // 2) setCharAt(i,'ch') = set character at index
        sb.setCharAt(0,'P');
        System.out.println(sb);

        // 3) insert(i,'ch') = insert character at index
        sb.insert(2,'n');
        System.out.println(sb);

        // 4) delete the extra 'n'
        // staring index is included but ending index is excluded.
        sb.delete(2,3);
        System.out.println(sb);

        // 5) append = add in end
        sb.delete(0,4);
        sb.append("h"); // str = str + "h"
        sb.append("e"); // str = str + "e"
        sb.append("l");
        sb.append("l");
        sb.append("o");
        System.out.println(sb);

        // 6) length() = gives length of string builder
        System.out.println(sb.length());

    }
}