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
            map.put(c, i);
            ++c;
        }

        int result = 0;
        int len = s.length() - 1;
        int t = 0;
        while (len >= 0) {
            char curr = s.charAt(len);
            result = result + (int) Math.pow(26, t) * map.get(curr);
            ++t;
            --len;
        }

        return result;
    }

}
