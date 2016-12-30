import java.util.Arrays;
import java.util.Collections;

public class MaxNumber {
    public static void main(String[] args) {
        int[] arr = { 98, 222, 39, 67, 12, 43, 7 };
        System.out.println(maxNumber(arr));
    }

    public static long maxNumber(int[] arr) {

        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException();
        }

        String[] strArr = new String[arr.length];

        for (int i = 0; i < arr.length; i++) {
            strArr[i] = String.valueOf(arr[i]);
        }

        Arrays.sort(strArr, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (String string : strArr) {
            sb.append(string);
        }

        return Long.valueOf(sb.toString());
    }

}
