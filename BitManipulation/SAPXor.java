import java.util.HashMap;
import java.util.Map;

public class SAPXor {
    // given an array with every element appears twice except for one
    // find that element
    public static void main(String[] args) {

        // 5 only appeared once
        int[] arr = { 2, 1, 3, 1, 3, 2, 7, 6, 5, 7, 6 };

        System.out.println(findSingle(arr));

    }

    public static int findSingle(int[] arr) {

        int result = 0;

        for (int i = 0; i < arr.length; i++) {
            result ^= arr[i];
        }

        return result;
    }

    // use hashmap key is char, val is occurence
    public static int findSingle2(int[] arr) {

        // what is the best way to tell which one has value 1
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        return -1;

    }

    // use set, if appears once + to sum , twice minus from sum
    public static int findSingle3(int[] arr) {
        return -1;
    }

}
