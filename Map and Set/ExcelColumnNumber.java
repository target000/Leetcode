import java.util.HashMap;
import java.util.Map;

public class ExcelColumnNumber {

    public static void main(String[] args) {

    }

    public static int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException("Input is not valid!");
        }

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char c = 'A';
        for (int i = 1; i <= 26; ++i) {
            // map A to 1, B to 2 ...
            map.put(c, i);
            // note 'A' + 1 = 'B'
            ++c;
        }

        int result = 0;
        int len = s.length() - 1;
        int i = 0;
        while (len >= 0) {
            char curr = s.charAt(len);
            // AA = 26*26
            result = result + (int) Math.pow(26, i) * map.get(curr);
            ++i;
            --len;
        }

        return result;
    }

    // Better
    public static int titleToNumber2(String s) {

        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException("Input is not valid!");
        }

        int result = 0;
        int len = s.length() - 1;
        int i = 0;

        // len will ensure that it goes from right to left
        while (len >= 0) {
            char curr = s.charAt(len);
            result = result + (int) Math.pow(26, i) * (curr - 'A' + 1);
            i++;
            len--;
        }

        return result;
    }

}
