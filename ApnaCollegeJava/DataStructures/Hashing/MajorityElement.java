/* Given an integer array of size n, find all elements that appear more than n/3 times.
   nums[] = {1, 3, 2, 5, 1, 3, 1, 5, 1};
   #1

   nums[] = {1, 2};
   #1,2

 */

package DataStructures.Hashing;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array : ");
        int size = sc.nextInt();

        int[] arr = new int[size];

        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<size; i++) {
            if(map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();

        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            if(e.getValue() > (size / 3)) {
                answer.add(e.getKey());
            }
        }

        System.out.println(answer);

        sc.close();
    }
}
