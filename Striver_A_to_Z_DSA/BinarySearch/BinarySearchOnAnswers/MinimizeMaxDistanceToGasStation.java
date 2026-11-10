package Striver_A_to_Z_DSA.BinarySearch.BinarySearchOnAnswers;

/*
You are given a sorted array ‘arr’ of length ‘n’, which contains positive integer positions of ‘n’ gas stations on the X-axis. You are also given an integer ‘k’. You have to place 'k' new gas stations on the X-axis. You can place them anywhere on the non-negative side of the X-axis, even on non-integer positions. Let 'dist' be the maximum value of the distance between adjacent gas stations after adding k new gas stations. Find the minimum value of ‘dist’.
*/

import java.util.Scanner;
import java.util.PriorityQueue;

public class MinimizeMaxDistanceToGasStation {

    static class Pair {
        double sectionLength;
        int index;

        Pair(double sectionLength, int index) {
            this.sectionLength = sectionLength;
            this.index = index;
        }
    }

    // Brute Approach
    // Time Complexity = O(N * K)
    // Space Complexity = O(N)
    public static double bruteApproach(int[] arr, int k) {
        int[] howMany = new int[arr.length - 1];

        for(int gasStations = 1; gasStations <= k; gasStations++) {
            double maxSection = -1;
            int maxInd = -1;

            for(int i=0; i<arr.length - 1; i++) {
                double difference = (double)arr[i+1] - arr[i];
                double sectionLength = difference / (double) (howMany[i] + 1);

                if(sectionLength > maxSection) {
                    maxSection = sectionLength;
                    maxInd = i;
                }
            }
            howMany[maxInd]++;
        }

        double maxAns = -1;

        for(int i=0; i<arr.length - 1; i++) {
            double difference = (double)arr[i+1] - arr[i];
            double sectionLength = difference / (double) (howMany[i] + 1);
            maxAns = Math.max(maxAns, sectionLength);
        }

        return maxAns;
    }

    // Better Approach
    // Time Complexity = O(K * logN + N * logN)
    // Space Complexity = O(N)
    public static double betterApproach(int[] arr, int k) {
        int n = arr.length;
        int[] howMany = new int[arr.length - 1];

        PriorityQueue<Pair> pq = new PriorityQueue<>((a , b) -> Double.compare(b.sectionLength, a.sectionLength));

        for(int i=0; i<n-1; i++) {
            pq.add(new Pair((double)arr[i+1] - arr[i], i));
        }

        for(int gasStations = 1; gasStations <= k; gasStations++) {
            Pair maxPair = pq.remove();
            int sectionIdx = maxPair.index;

            howMany[sectionIdx]++;

            double oldDiff = arr[sectionIdx + 1] - arr[sectionIdx];
            double newSectionLength = oldDiff / (double) (howMany[sectionIdx] + 1);

            pq.add(new Pair(newSectionLength, sectionIdx));
        }

        return pq.remove().sectionLength;
    }
    

    // Optimal Approach
    // Time Complexity = O(N * log(maxDistance * 10^6))
    // Space Complexity = O(1)
    public static double optimalApproach(int[] arr, int k) {
        double low = 0;
        double high = maxConsecutiveDistance(arr);

        while(high - low > 1e-6) {
            double mid = low + (high - low) / 2.0;

            if(isPossible(arr, k, mid)) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return high;
    }

    public static double maxConsecutiveDistance(int[] arr) {
        double ans = -1;

        for(int i=0; i<arr.length - 1; i++) {
            ans = Math.max(ans, (double)arr[i+1] - arr[i]);
        }

        return ans;
    }

    public static boolean isPossible(int[] arr, int k, double mid) {
        int count = 0;

        for(int i=0; i<arr.length - 1; i++) {
            int numberInBetween = (int)((arr[i+1] - arr[i]) / mid);
            if((arr[i+1] - arr[i]) / mid == numberInBetween * mid) {
                numberInBetween--;
            }
            count += numberInBetween;
            
            if(count > k) {
                return false;
            }
        }

        return count <= k;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of gas stations: ");
        int n = sc.nextInt();

        int[] distances = new int[n];
        System.out.println("Enter distance of " + n + " gas stations: ");
        for(int i=0; i<n; i++) {
            distances[i] = sc.nextInt();
        }

        System.out.print("Enter number of new gas stations to be placed: ");
        int k = sc.nextInt();

        // brute approach
        System.out.println("Minimum value of maximum distance between adjacent gas stations after adding " + k + " new gas stations (Brute Approach): " + bruteApproach(distances, k));

        // better approach
        System.out.println("Minimum value of maximum distance between adjacent gas stations after adding " + k + " new gas stations (Better Approach): " + betterApproach(distances, k));

        // optimal approach
        System.out.println("Minimum value of maximum distance between adjacent gas stations after adding " + k + " new gas stations (Optimal Approach): " + optimalApproach(distances, k));

        sc.close();
    }    
}