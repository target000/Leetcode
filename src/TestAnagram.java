
public class TestAnagram {
    public static void main(String[] args) {

    }

    // O(n)
    public static boolean isAnagram(String s, String t) {

        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }

        for (int num : arr) {
            if (num != 0) {
                return false;
            }
        }

        return true;
    }
    
    
    // O(n) hashmap

    // O(nlogn)

}
