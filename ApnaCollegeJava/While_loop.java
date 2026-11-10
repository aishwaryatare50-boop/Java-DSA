public class While_loop {
    public static void main(String args[]) {
        int i=0;
        while(i<11) {
            System.out.println(i);
            i++;
        }

// We have reinitialised i because i is already updated to 11.        

        i=0;
        while(i<=10) {
            System.out.print(i+" ");
            i++;
        }
    }
}
