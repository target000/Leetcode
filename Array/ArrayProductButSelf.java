// apparently the best way to do it is to multiple all numbers and divide by current arr value
// but it is against the requirement

// basically do a forward sweep to cumulatively find the product
// then do a backward sweep 

public class ArrayProductButSelf {

    public int[] productExceptSelf(int[] arr) {

        if (arr == null || arr.length == 0) {
            return arr;
        }

        int n = arr.length;
        int[] res = new int[n];
        res[0] = 1;

        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * arr[i - 1];
        }

        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= arr[i];
        }

        return res;
    }

}
