package Extra_Questions;
// Bit manipulation

public class Extra_Question_16 {
    public static void main(String[] args) {
        int n = 5;
        // left shift operator << shifts bit to left by i places
        // n << i = multiplies n by 2 i times 
        // eg. 5 << 1 = 5 * 2 = 10
        // 5 << 2 = 5 * 2 * 2 = 20
        System.out.println(n << 1);

        int m = 100;
        // right shift opertor >> shifts bit to left by i places
        // n >> i = divides n by 2 i times
        // eg. 100 >> 1 = 100 / 2 = 50
        // 100 >> 2 = 100 / (2 * 2) = 25
        System.out.println(m >> 2);


        // to get negation of a use ~(bit wise not operator)
        // ~10 = -11 to get 10 : ~10+1 = -10
        int a = 10;
        System.out.println(~a+1);
    }
}
