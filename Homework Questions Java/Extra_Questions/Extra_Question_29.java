// Find the number of ways in which you can invite n people to your party, single or in pairs. 

package Extra_Questions;

import java.util.Scanner;

public class Extra_Question_29 {
    public static int waysToInvitePeople(int n) {
        if(n <= 1) {
            return 1;
        }

        // way1 = invite n single and leave other n-1 to lower levels
        int way1 = waysToInvitePeople(n-1);

        // way2 = invite n as pair. Now there are n-1 options to pair with n and then we call other n-2 remaining guests
        int way2 = (n-1)*waysToInvitePeople(n-2);

        return way1+way2;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of people : ");
        int n = sc.nextInt();

        System.out.println(waysToInvitePeople(n));

        sc.close();
    }
}
