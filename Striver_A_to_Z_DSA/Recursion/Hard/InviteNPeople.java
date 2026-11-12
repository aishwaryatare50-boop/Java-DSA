// Find the number of ways in which you can invite n people to your party, single or in pairs.

package Striver_A_to_Z_DSA.Recursion.Hard;

public class InviteNPeople {

    // Time Complexity = O(2 ^ n)
    // Space Complexity = O(n) // recursion stack space
    public static int noOfWaysToInviteNPeople(int n) {
        if(n == 1 ||  n == 2) {
            return n;
        }

        // solo invitation
        int single = noOfWaysToInviteNPeople(n - 1);

        // pair invitation
        int pair = (n - 1) * noOfWaysToInviteNPeople(n - 2);

        return single + pair; // total no. of ways to invite n people
    }

    public static void main(String[] args) {
        System.out.println(noOfWaysToInviteNPeople(5));
    }    
}