// Find first and last occurence of an element in a string

package Extra_Questions;

public class Extra_Question_19 {
    public static int firstOcc = -1;
    public static int lastOcc = -1;
    public static void occurence(char ele, String str, int idx) {
        
        if(idx == str.length()) {
            if(firstOcc == -1) {
                System.out.println("Element does not exist");
                return;
            }
            System.out.println("First Occurence of element is at index : " + firstOcc);
            System.out.println("Last Occurence of element is at index : " + lastOcc);
            return;
        }

        if(str.charAt(idx) == ele) {
            if(firstOcc == -1) {
                firstOcc = idx;
            }
            lastOcc = idx;
        }

        occurence(ele, str, idx+1);

    }
    
    public static void main(String[] args) {
        String str = "aabbfgjkca";
        occurence('c', str, 0);
    }
}
