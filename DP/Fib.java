import java.math.BigInteger;

public class Fib {
    public static void main(String[] args) {

        System.out.println(getFib(10001));

    }

    // Fib: F(n) = F(n-1) + F(n-2) where F(0) = 0 and F(1) = 1
    // this is the simplest example of DP
    public static BigInteger getFib(int n) {

        BigInteger[] arr = new BigInteger[n];

        arr[0] = new BigInteger("0");
        arr[1] = new BigInteger("1");

        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 1].add(arr[i - 2]);
        }
        // System.out.println(Arrays.toString(arr));

        return arr[n - 1];
    }

}
