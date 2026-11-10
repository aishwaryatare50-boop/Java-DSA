import java.util.*;

public class Arrays {
    public static void main(String args[]) {
        // defining an array
       // int[] marks = new int[3];

        // we can also declare an array by : 
        int marks[] = new int[3];

        // we can also declare an array by: 
        int mark[] = {98, 99, 100};

        marks[0] = 97; //physics
        marks[1] = 98; //chemistry
        marks[2] = 95; //eng

        System.out.println(marks[0]);
        System.out.println(marks[1]);
        System.out.println(marks[2]);

        // or we can also code
        for(int i=0; i<3; i++) {
            System.out.println(mark[i]);
        }

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        int numbers[] = new int[size];

        for(int i=0; i<size; i++) {
            numbers[i] = sc.nextInt();
        }

        for(int i=0; i<size; i++) {
            System.out.println(numbers[i]);
        }

        sc.close();
    }
}
