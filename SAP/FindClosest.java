// precondition: array is sorted

public class FindClosest {

    public static void main(String[] args) {

        int[] testArr = { 1, 2, 3, 4, 5, 99, 100, 101, 102 };
        int target = 8;

        // System.out.println(findClosest(testArr, 0, testArr.length - 1, target));
        System.out.println(findClosest3(testArr, target));
    }

    public static int findClosest(int[] arr, int low, int high, int t) {
        // note that in the recursive version, exit condition is mentioned in the front
        // Element is not found, find closest
        if (low > high) {
            if (low >= arr.length) {
                low = arr.length - 1;
            }

            if (high < 0) {
                high = 0;
            }

            int distanceToLeft = Math.abs(arr[low] - t);
            int distanceToRight = Math.abs(arr[high] - t);

            return distanceToLeft < distanceToRight ? arr[low] : arr[high];
        }

        // recursive binary search
        int mid = (low + high) / 2;
        if (arr[mid] == t) {
            return t;
        } else if (arr[mid] > t) {
            return findClosest(arr, low, mid - 1, t);
        }
        return findClosest(arr, mid + 1, high, t);
    }

    // Geng Li - WRONG CODE! Noob lol
    public static int findClosest2(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;

        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (A[mid] > target) {
                end = mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                return A[mid];
            }
        }

        if (Math.abs(A[start] - target) > Math.abs(A[end] - target)) {
            return A[end];
        }

        if (Math.abs(A[start] - target) <= Math.abs(A[end] - target)) {
            return A[start];
        }

        return -1;
    }

    // I have corrected Geng's solution here
    // This is the iterative approach
    public static int findClosest3(int[] A, int target) {

        if (A == null || A.length == 0) {
            throw new IllegalArgumentException("make sure your shit is correct!");
        }

        int start = 0;
        int end = A.length - 1;

        while (start <= end) {
            int mid = (end - start) / 2 + start;

            if (A[mid] == target) {
                return A[mid];
            } else if (target < A[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        // readjust the edge cases, careful me haha
        if (end == -1) {
            end = 0;
        }

        if (start == A.length) {
            start = A.length - 1;
        }

        return (Math.abs(target - A[start]) < Math.abs(target - A[end])) ? A[start] : A[end];
    }
}
