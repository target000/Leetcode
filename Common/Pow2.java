public class Pow2 {
    public double myPow(double x, int n) {
        if (x == 1.0) {
            return 1.0;
        }

        if (x == -1.0) {
            if (n % 2 == 0) {
                return 1;
            } else {
                return -1;
            }
        }

        if (n > 0) {
            if (n == 1) {
                return x;
            } else if (n % 2 == 0) {
                double res = myPow(x, n / 2);
                return res * res;
            } else {
                return x * myPow(x, n - 1);
            }
        } else if (n < 0) {
            return 1 / myPow(x, -1 * n);
        } else {
            return 1;
        }
    }
}