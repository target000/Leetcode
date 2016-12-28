import java.util.HashSet;
import java.util.Set;

public class Duplicate1 {
    public static void main(String[] args) {

    }

    // O(n)
    public static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;

        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }

        return false;
    }

}