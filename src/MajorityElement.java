import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MajorityElement {
    public static void main(String[] args) {

        int[] arr = { 7, 1, 7, 1, 7, 1, 7, 2, 7, 7, 3, 4, 7, 7, 5 };

        System.out.println(findMajority(arr));

    }

    public static int findMajority(int[] arr) throws IllegalArgumentException {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        for (Entry<Integer, Integer> pair : map.entrySet()) {
            if ((int) pair.getValue() > arr.length / 2) {
                return (int) pair.getKey();
            }
        }

        throw new IllegalArgumentException();
    }
}
