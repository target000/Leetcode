// the key is determine which interval the target falls into

public class SearchRotatedArr {
    public static void main(String[] args) {

    }

    // Recursive
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    public int binarySearch(int[] nums, int left, int right, int target) {
        if (left > right)
            return -1;

        int mid = left + (right - left) / 2;

        if (target == nums[mid])
            return mid;

        if (nums[left] <= nums[mid]) {
            if (nums[left] <= target && target < nums[mid]) {
                return binarySearch(nums, left, mid - 1, target);
            } else {
                return binarySearch(nums, mid + 1, right, target);
            }
        } else {
            if (nums[mid] < target && target <= nums[right]) {
                return binarySearch(nums, mid + 1, right, target);
            } else {
                return binarySearch(nums, left, mid - 1, target);
            }
        }
    }

    // Iterative
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
