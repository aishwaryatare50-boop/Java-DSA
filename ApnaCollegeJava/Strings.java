import java.util.*;

public class Strings {
    public static void main(String args[]) {
        // String Declaration
        String name = "Tony";
        String FullName = "Tony Stark";

        // output string
        System.out.println(name + FullName);

        // input string
        Scanner sc = new Scanner(System.in);
        String Name = sc.next();
        System.out.println("Your name is : " + Name);

        // Functions on Strings

        // 1) Concatenation -> add 2 strings
        String firstName = "Tony";
        String lastName = "Stark";
        String fullName = firstName + " " + lastName;
        System.out.println(fullName);

        // 2) Length -> gives length of string
        // syntax -> stringName.length()
        System.out.println(fullName.length()); 

        // 3) charAt -> prints all the characters in string
        for(int i=0; i<fullName.length(); i++) {
            System.out.println(fullName.charAt(i));
        }

        // 4) Compare
        String name1 = "Tony";
        String name2 = "Tony";

        // Case-1 = String1 > String2 : +ve value
        // Case-2 = String1 == String2 : 0
        // Case-3 = String1 < String2 : -ve value

        // Ex: hello < wello , hello > cello, aahello > aacello
 
        if(name1.compareTo(name2) == 0) {
            System.out.println("Strings are equal.");
        } else {
            System.out.println("Strings are not equal.");
        } 

        // in this case answer will be strings are not equal so never compare two strings with == operator

        if(new String("Tony") == new String("Tony")) {
            System.out.println("Strings are equal.");
        } else {
            System.out.println("Strings are not equal.");
        }

        // 5) substring = part of a string
        // substring(beginningIndex, endingIndex)
        // here beginningIndex is included but endingIndex is excluded.
        // if endingIndex is last index of string it is not necessary to define it.

        String sentence = "My name is Tony";
        String nameInSentence = sentence.substring(11,sentence.length());
        System.out.println(nameInSentence);

        // 6) ParseInt Method of Integer class -> convert string to integer
        String str = "123";
        int number = Integer.parseInt(str);
        System.out.println(number);

        // 7) ToString Method of Integer class -> conver integer to string
       int Number = 123;
       String Str = Integer.toString(Number);
       System.out.println(Str.length());
       System.out.println(Str);
     
        // "Strings are Immutable"
        
        sc.close();
    }
}