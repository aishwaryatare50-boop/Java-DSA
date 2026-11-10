import java.util.*;

public class Bit_Manipulation {
    public static void main(String args[]) {

        // 1) Get Bit

        int n = 5; // 0101
        int pos = 3;
        int bitMask = 1<<pos;

        if((bitMask & n) == 0) {
            System.out.println("Bit was zero.");
        } else {
            System.out.println("Bit was one.");
        }

        // 2) Set Bit

        n = 5; // 0101
        pos = 1;
        bitMask = 1<<pos;

        int newNumber = bitMask | n ;
        System.out.println(newNumber); // 7 -> 0111

        // 3) Clear Bit

        n = 5; // 0101
        pos = 2;
        bitMask = 1<<pos;
        int notBitMask = ~bitMask;

        newNumber = notBitMask & n;
        System.out.println(newNumber);

        // 4) Update Bit 

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter operation : ");
        int oper = sc.nextInt();
        // oper = 1 : set
        // oper = 0 : clear

        n = 5; // 0101
        pos = 1;
        bitMask = 1<<pos;

        if(oper == 1 ) {
            // set
            newNumber = bitMask | n;
            System.out.println(newNumber);   
        } else {
            // clear
            int newBitMask = ~(bitMask);
            int NewNumber  = newBitMask & n ;
            System.out.println(NewNumber);
        }
        sc.close();
    }
}
