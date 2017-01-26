import java.io.InputStream;
import java.util.LinkedList;
import java.util.Scanner;

public class IO {

    // Write a class that can take in an endless stream of numbers,
    // one integer at a time, can efficiently store the most recent n numbers and report their average in O(1) time.
    public static void main(String[] args) {

    }

    private LinkedList<Integer> list;
    private int n;

    public IO(int n) {
        this.n = n;
    }

    public void read(InputStream stream) {
        Scanner in = new Scanner(stream);
        list = new LinkedList<Integer>();

        // change to long if needed or even BigInteger but then adjust sum operations
        int sum = 0;
        while (true) {
            int val = in.nextInt();
            sum += val;
            list.add(val);
            if (list.size() > n) {
                int old = (int) list.remove(0);
                sum -= old;
            }
            // do what is needed with average (last n seen numbers or list size if less)
            // average = sum / list.size();
        }
    }

}
