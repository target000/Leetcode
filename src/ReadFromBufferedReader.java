import java.io.InputStream;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Write a class that can take in an endless stream of numbers,
// one integer at a time, can efficiently store the most recent n numbers and report their average in O(1) time.

public class ReadFromBufferedReader {

    private static final String FILENAME = "C:\\filename.txt";

    public static void main(String[] args) {

        BufferedReader br = null;
        FileReader fr = null;

        try {

            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);

            String sCurrentLine;

            br = new BufferedReader(new FileReader(FILENAME));

            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }

    }

}

// private LinkedList<Integer> list;
// private int n;
//
// public IO(int n) {
// this.n = n;
// }
//
// public void read(InputStream stream) {
// Scanner in = new Scanner(stream);
// list = new LinkedList<Integer>();
//
// // change to long if needed or even BigInteger but then adjust sum operations
// int sum = 0;
// while (true) {
// int val = in.nextInt();
// sum += val;
// list.add(val);
// if (list.size() > n) {
// int old = (int) list.remove(0);
// sum -= old;
// }
// // do what is needed with average (last n seen numbers or list size if less)
// // average = sum / list.size();
// }
// }
