
public class FindClosest {
    int findClosest(int[] a, int left, int right, int t) {
        // Element is not found, find closest
        if (left > right) {
            if (left >= a.length) {
                left = a.length - 1;
            }
            if (right < 0) {
                right = 0;
            }
            int distanceToLeft = Math.abs(a[left] - t);
            int distanceToRight = Math.abs(a[right] - t);
            return distanceToLeft < distanceToRight ? a[left] : a[right];
        }
        // Below is the same for typical binary search
        int mid = (left + right) / 2;
        if (a[mid] == t) {
            return t;
        } else if (a[mid] > t) {
            return findClosest(a, left, mid - 1, t);
        }
        return findClosest(a, mid + 1, right, t);
    }
}
