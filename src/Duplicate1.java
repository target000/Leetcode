import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Duplicate1 {
    public static void main(String[] args) {

        // note set return false when the value has already been added
        Set<Integer> set = new HashSet<Integer>();
        System.out.println(set.add(1));
        // this should return false since been previously added
        System.out.println(set.add(1));

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

    // O(nlogn)
    // sort the array, compare neighboring elements
    public static boolean containsDuplicate2(int[] arr) {

        if (arr == null || arr.length == 0)
            return false;

        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] == arr[i]) {
                return true;
            }
        }

        return false;
    }

}