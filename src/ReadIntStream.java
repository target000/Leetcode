import java.io.InputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ReadIntStream {
    private Queue<Integer> q = new LinkedList<Integer>();
    private int capacity;
    private int sum = 0;

    public ReadIntStream(int capacity) {
        this.capacity = capacity;
    }

    public void readStream(InputStream stream) {
        Scanner in = new Scanner(stream);

        while (true) {
            int val = in.nextInt();
            sum += val;
            q.add(val);
            if (q.size() > capacity) {
                int old = (int) q.poll();
                sum -= old;
            }
        }
    }

    public double getAverage() {
        return sum / (q.size() * 1.0);
    }
}