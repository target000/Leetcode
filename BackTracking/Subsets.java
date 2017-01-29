import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        int[] testArr = { 1, 2, 3 };

        List<List<Integer>> out = subsets(testArr);

        for (List<Integer> list : out) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> subsets(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        List<List<Integer>> list = new ArrayList<List<Integer>>();
        // Personally I don't think it is necessary to presort the array
        // Arrays.sort(nums);
        backtrack(list, new ArrayList<Integer>(), arr, 0);

        return list;
    }

    // note this is like the string permutation problem
    private static void backtrack(List<List<Integer>> listOfList, List<Integer> tempList, int[] arr, int startIndex) {

        listOfList.add(new ArrayList<Integer>(tempList));

        for (int i = startIndex; i < arr.length; i++) {
            tempList.add(arr[i]);
            backtrack(listOfList, tempList, arr, i + 1);
            tempList.remove(tempList.size() - 1);
        }

    }
}
