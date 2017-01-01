import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {

    // write a function to test if two strings are isomorphic

    // Isomorphic: aac - > bbg, a -> b , abc -> def
    // non-isomorphic: aac -> bxb, aaaa -> ghij

    public static void main(String[] args) {

        System.out.println(isIsomorphic("aba", "ded"));
        System.out.println(isIsomorphic("aaa", "bbb"));
        System.out.println(isIsomorphic("abbb", "abbb"));

        System.out.println(isIsomorphic("xy", "aa"));
        System.out.println(isIsomorphic("123", "122"));
        System.out.println(isIsomorphic("aaaaaaaa", "bbbbbbb"));

    }

    public static boolean isIsomorphic(String s, String t) {

        // handle special conditions first, exit early so no computation will be
        // wasted
        if (s == null || t == null)
            return false;

        if (s.length() != t.length())
            return false;

        Map<Character, Character> map = new HashMap<Character, Character>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // 4 possible cases

            // 1) contains c1 but not c2, fail, this implies c1 was seen before
            // 2) contains c1 and c2, in this case do nothing
            // 3) doesn't contain c1 but contains c2, fail, this implies c2 was seen before and mapped to someone else
            // 4) doesn't contain c1 nor contains c2, neither chars have been seen before

            if (map.containsKey(c1) && map.get(c1) != c2) {
                return false;
            } else if (map.containsKey(c1) && map.get(c1) == c2) {
                // no operation
            } else if (!map.containsKey(c1) && map.containsValue(c2)) {
                return false;
            } else if (!map.containsKey(c1) && !map.containsValue(c2)) {
                map.put(c1, c2);
            }

            // // simplified form
            // if (map.containsKey(c1)) {
            // if (map.get(c1) != c2) {
            // return false;
            // } else {
            // // nop
            // }
            // } else {
            // if (map.containsValue(c2)) {
            // return false;
            // } else {
            // map.put(c1, c2);
            // }
            // }
        }
        return true;
    }

}
