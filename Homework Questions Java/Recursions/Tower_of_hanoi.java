package Recursions;

public class Tower_of_hanoi {
    public static void towerOfHanoi(String source, String helper, String destination, int n) {
        if(n == 1) {
            System.out.println("Move disk " + n + " from " + source + " to " + destination);
            return;
        }

        towerOfHanoi(source, destination, helper, n-1);
        System.out.println("Move disk " + n + " from " + source + " to " + destination);
        towerOfHanoi(helper, source, destination, n-1);
    
    }

    public static void main(String[] args) {
        int n = 3;
        towerOfHanoi("S", "H", "D", n);
    }
}