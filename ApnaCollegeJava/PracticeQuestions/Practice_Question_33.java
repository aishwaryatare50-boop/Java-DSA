// Find the 1st and last occurence of an element in string
// "abaacdaefaah"

// Time Complexity => O(n), here n is length of string

import java.util.*;

public class Practice_Question_33 {

    public static int first = -1; // Declaration of static variables
    public static int last = -1;  // i.e. like a global declaration not exact

    public static void elementOccurence(int index, String str, char element) {
        
        if(index == str.length()) {
            System.out.println("'" + element + "'" + " first occured at index : " + first);
            System.out.println("'" + element + "'" + " last occured at index : " + last);
            return;
        }
        char currChar = str.charAt(index);
        if(currChar == element) {
            if(first == -1) {
                first = index;
            } else {
                last = index;
            }
        }

        elementOccurence(index + 1, str, element);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter String : ");
        String str = sc.nextLine();
        int index = 0;

        System.out.print("Enter element to be searched : ");
        char element = sc.next().charAt(0);

        elementOccurence(index, str, element);

        sc.close();
    }
}
