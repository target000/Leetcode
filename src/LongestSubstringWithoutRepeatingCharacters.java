import java.util.HashSet;
import java.util.Set;

// http://www.programcreek.com/2013/02/leetcode-longest-substring-without-repeating-characters-java/

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s == null)
            return 0;
        boolean[] flag = new boolean[256];

        int result = 0;
        int start = 0;
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            char current = arr[i];
            if (flag[current]) {
                result = Math.max(result, i - start);
                // the loop update the new start point
                // and reset flag array
                // for example, abccab, when it comes to 2nd c,
                // it update start from 0 to 3, reset flag for a,b
                for (int k = start; k < i; k++) {
                    if (arr[k] == current) {
                        start = k + 1;
                        break;
                    }
                    flag[arr[k]] = false;
                }
            } else {
                flag[current] = true;
            }
        }

        result = Math.max(arr.length - start, result);

        return result;
    }

    public int lengthOfLongestSubstringUsingHashSet1(String s) {
        if (s == null || s.length() == 0)
            return 0;

        Set<Character> set = new HashSet<Character>();

        int max = 0;

        int i = 0;
        int start = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (!set.contains(c)) {
                set.add(c);
            } else {
                max = Math.max(max, set.size());

                while (start < i && s.charAt(start) != c) {
                    set.remove(s.charAt(start));
                    start++;
                }
                start++;
            }

            i++;
        }

        max = Math.max(max, set.size());

        return max;
    }

    public int lengthOfLongestSubstringUsingHashset2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int start = 0;
        int max = 0;

        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!set.contains(c)) {
                set.add(c);

                max = Math.max(max, i - start + 1);
            } else {
                for (int j = start; j < i; j++) {
                    set.remove(s.charAt(j));

                    if (s.charAt(j) == c) {
                        start = j + 1;
                        break;
                    }
                }

                set.add(c);
            }
        }

        return max;
    }

}
