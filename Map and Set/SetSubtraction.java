import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetSubtraction {
    public static void main(String[] args) {
        // this is probabaly the easist way to do it
        Set<Integer> set = new HashSet<Integer>();

        int[] arr1 = { 1, 2, 3 };
        int[] arr2 = { 3, 4, 5 };

        for (int i : arr1) {
            set.add(i);
        }

        for (int i : arr2) {
            set.remove(i);
        }

        // get the wrapper version, can i directly get the primitive array version?
        Integer[] arrOut = set.toArray(new Integer[set.size()]);
        System.out.println("Integer");
        System.out.println(Arrays.toString(arrOut));

        int[] arrOut2 = new int[arrOut.length];
        int i = 0;
        for (Integer integer : arrOut) {
            arrOut2[i++] = integer.intValue();
        }

        // get the array version
        System.out.println("int");
        System.out.println(Arrays.toString(arrOut2));

        // get the set version
        System.out.println("set");
        System.out.println(set.toString());

        // should come up wtih a way to handle duplicates
    }

}
