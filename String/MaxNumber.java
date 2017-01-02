import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class MaxNumber {
    public static void main(String[] args) {
        int[] arr = { 98, 222, 39, 67, 12, 43, 7 };
        System.out.println(maxNumber(arr));

    }

    // reverse lex sorting
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

    // different requirement, now need to sort them by digits
    // TODO
    public static long maxNumberByDigits(int[] arr) {
        int number = 85719;
        LinkedList<Integer> stack = new LinkedList<Integer>();
        while (number > 0) {
            stack.push(number % 10);
            number = number / 10;
        }

        return 0;
    }

}
