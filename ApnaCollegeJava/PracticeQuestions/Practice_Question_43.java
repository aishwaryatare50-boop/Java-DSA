/* Find the number of ways in which you can invite n people to 
 * your part, single or in pairs.
 */

public class Practice_Question_43 {

    public static int callGuests(int n) {
        if(n <= 1) {
            return 1;
        }

        // single
        int ways1 = callGuests(n-1);

        // pairs
        int ways2 = (n-1) * callGuests(n-2);

        return ways1 + ways2;
    }
    public static void main(String args[]) {
        int n = 5;
        System.err.println(callGuests(n));
    }
}
