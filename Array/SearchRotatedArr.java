// the key is determine which interval the target falls into

public class SearchRotatedArr {
    public static void main(String[] args) {

    }

    // Recursive
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    public int binarySearch(int[] arr, int left, int right, int target) {
        if (left > right)
            return -1;

        int mid = left + (right - left) / 2;

        if (target == arr[mid])
            return mid;

        // if arr[left] <= arr[mid] then arr is monotonically increasing from left to mid
        // thus if target falls into this region, go recurse this region
        // otherwise go recurse the other half
        if (arr[left] <= arr[mid]) {
            if (arr[left] <= target && target < arr[mid]) {
                return binarySearch(arr, left, mid - 1, target);
            } else {
                return binarySearch(arr, mid + 1, right, target);
            }
        } else {
            if (arr[mid] < target && target <= arr[right]) {
                return binarySearch(arr, mid + 1, right, target);
            } else {
                return binarySearch(arr, left, mid - 1, target);
            }
        }
    }

    // Iterative
    // In the iterative solution, basically just have to update the index of low and high
    public class Solution {
        public int search(int[] A, int target) {
            int lo = 0;
            int hi = A.length - 1;
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (A[mid] == target)
                    return mid;

                if (A[lo] <= A[mid]) {
                    if (target >= A[lo] && target < A[mid]) {
                        hi = mid - 1;
                    } else {
                        lo = mid + 1;
                    }
                } else {
                    if (target > A[mid] && target <= A[hi]) {
                        lo = mid + 1;
                    } else {
                        hi = mid - 1;
                    }
                }
            }
            return A[lo] == target ? lo : -1;
        }
    }

}
