public class Do_While_loop {
    public static void main(String args[]) {
        int i=0;
        do {
            System.out.println(i);
            i++;
        } while(i<11);

        // condition is false but code is still executed atleast once.
        i=12;
        do {
            System.out.println(i);
            i++;
        } while(i<11);
    }
}
