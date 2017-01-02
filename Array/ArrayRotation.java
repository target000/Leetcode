
public class ArrayRotation {
    public static void main(String[] args) {

    }

    // Common method
    // O(n) time O(n) space
    public void rotate(int[] nums, int k) {
        if (k > nums.length)
            k = k % nums.length;

        int[] result = new int[nums.length];

        for (int i = 0; i < k; i++) {
            result[i] = nums[nums.length - k + i];
        }

        int j = 0;
        for (int i = k; i < nums.length; i++) {
            result[i] = nums[j];
            j++;
        }

        System.arraycopy(result, 0, nums, 0, nums.length);
    }

    // Bubble O(n^2)
    public static void rotate2(int[] arr, int order) {
        if (arr == null || order < 0) {
            throw new IllegalArgumentException("Illegal argument!");
        }

        for (int i = 0; i < order; i++) {
            for (int j = arr.length - 1; j > 0; j--) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }
    }

    // O(n) time O(1) space, in-place algorithm
    public static void rotate3(int[] arr, int order) {
        if (arr == null || arr.length == 0 || order < 0) {
            throw new IllegalArgumentException("Illegal argument!");
        }

        if (order > arr.length) {
            order = order % arr.length;
        }

        // length of first part
        int a = arr.length - order;

        reverse(arr, 0, a - 1);
        reverse(arr, a, arr.length - 1);
        reverse(arr, 0, arr.length - 1);

    }

    // I have a for loop version, while loop is intersting as well
    public static void reverse(int[] arr, int left, int right) {
        if (arr == null || arr.length == 1)
            return;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
