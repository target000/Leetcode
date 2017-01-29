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

    // Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
    // Note: The solution set must not contain duplicate triplets.

    // Additional requirements: 1) no duplicates are allowed 2) monotonically increasing triplets
    // Basic idea: pre-sort the array and consider the array as 'first' + 'rest'
    // The rest should be -arr[i]
    // Maintain two pointers low and high going from two directions in the rest array and progressively sweep bidirectionally
    // Time complexity: sort is nlogn but for nested is O(n^2) and thus dominating.
    // O(n^2) algorithm
    public static List<List<Integer>> threeSum(int[] arr) {

        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for (int i = 0; i < arr.length - 2; i++) {
            if (i == 0 || (i > 0 && arr[i] != arr[i - 1])) {

                int low = i + 1;
                int high = arr.length - 1;
                int sum = 0 - arr[i];

                // go check the 'rest' of the arr to see if they add up to be -arr[i] and thus resulting arr[i] + arr[low] + arr[high] == 0
                while (low < high) {
                    if (arr[low] + arr[high] == sum) {
                        result.add(Arrays.asList(arr[i], arr[low], arr[high]));
                        while (low < high && arr[low] == arr[low + 1]) {
                            // handles duplicate, as per problem statement it doesn't allow duplicates
                            low++;
                        }
                        while (low < high && arr[high] == arr[high - 1]) {
                            // handles duplicate, as per problem statement it doesn't allow duplicates
                            high--;
                        }
                        low++;
                        high--;
                    } else if (arr[low] + arr[high] < sum) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }

        return result;
    }

}
