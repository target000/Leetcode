import java.util.HashSet;
import java.util.Set;

public class Duplicate1 {
    public static void main(String[] args) {

    }

    public static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;

        Set<Integer> set = new HashSet<Integer>();
        for (int i : nums) {
            if (!set.add(i)) {
                return true;
            }
        }

        return false;
    }

}
