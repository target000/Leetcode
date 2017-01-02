import java.util.HashMap;
import java.util.Map;

class Max {

    public static void main(String[] args) {
        // need brute force as well
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0 || s == null || s.length() == 0)
            return 0;

        if (s.length() < k)
            return s.length();

        Map<Character, Integer> map = new HashMap<Character, Integer>();

        int maxLen = k;
        int left = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }

            // when the size of map is greater than k, recalculate max and start removing
            if (map.size() > k) {
                maxLen = Math.max(maxLen, i - left);

                while (map.size() > k) {

                    char c2 = s.charAt(left);
                    if (map.get(c2) == 1) {
                        map.remove(c2);
                    } else {
                        map.put(c2, map.get(c2) - 1);
                    }

                    left++;
                }
            }
        }

        maxLen = Math.max(maxLen, s.length() - left);

        return maxLen;
    }

}