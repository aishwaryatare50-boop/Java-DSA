package Striver_A_to_Z_DSA.Arrays.Medium;

import java.util.Scanner;

public class BestTimeToBuyAndSellStocks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }

        int minCostPrice = arr[0];
        int maxProfit = 0;

        // Time Complexity = O(N)
        // Space Complexity = O(1)
        for(int i=1; i<arr.length; i++) {
            int sellingPrice = arr[i];
            int profit = sellingPrice - minCostPrice;

            if(profit > maxProfit) {
                maxProfit = profit;
            }
            
            if(arr[i] < minCostPrice) {
                minCostPrice = arr[i];
            }
        }

        System.out.println(maxProfit);

        sc.close();
    }
}