
// Implement a function to test if a number if power of 2

// Observe that power of 2 in binary is in the form of 1000
// 8 -- 1000        1000 - 1 = 111      1000 & 111 => 0
// 4 -- 100         100 - 1 = 11        100 & 11 => 0
// 2 -- 10          10 - 1 = 1          10 & 1 => 0
// 1 -- 1           1 - 1 = 0           1 & 0 => 0

public class PowerOf2 {
    public static void main(String[] args) {

        int n = 32;
        System.out.println(isPowerOf2(n));

    }

    public static boolean isPowerOf2(int n) {
        if (n < 0) {
            return false;
        }

        return (n & (n - 1)) == 0;
    }

}
