import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        int[] testArr = { 1, 3, 2, 1, -2, 1, 4, 3, -3 };
        List<List<Integer>> res = threeSum(testArr);

        for (List<Integer> list : res) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> threeSum(int[] num) {

        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        for (int i = 0; i < num.length - 2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i - 1])) {

                int low = i + 1;
                int high = num.length - 1;
                int sum = 0 - num[i];

                while (low < high) {
                    if (num[low] + num[high] == sum) {
                        res.add(Arrays.asList(num[i], num[low], num[high]));
                        while (low < high && num[low] == num[low + 1]) {
                            // handles duplicate, as per problem statement it doesn't allow duplicates
                            low++;
                        }
                        while (low < high && num[high] == num[high - 1]) {
                            // handles duplicate, as per problem statement it doesn't allow duplicates
                            high--;
                        }
                        low++;
                        high--;
                    } else if (num[low] + num[high] < sum) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }
        return res;
    }

}
