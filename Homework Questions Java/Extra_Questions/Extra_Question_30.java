// WAP to print subset of first n natural numbers

package Extra_Questions;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Extra_Question_30 {
    public static void subset(List<Integer> list, int n) {
        if(n < 1) {
            System.out.println(list);
            return ;
        }

        // to be
        list.add(n);
        subset(list,n-1);

        // to not be
        list.remove(list.size()-1);
        subset(list,n-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n : ");
        int n = sc.nextInt();

        List<Integer> list = new ArrayList<>();

        subset(list, n);

        sc.close();
    }
}
