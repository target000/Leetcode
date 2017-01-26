public class WoodCut {
    /**
     * @param L:
     *            Given n pieces of wood with length L[i]
     * @param k:
     *            An integer return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        if (L == null || L.length == 0) {
            return 0;
        }

        int max = 0;
        for (int i = 0; i < L.length; i++) {
            max = max < L[i] ? L[i] : max;
        }

        int start = 0;
        int end = max;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (numberOfPieces(L, mid) < k) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (numberOfPieces(L, end) >= k) {
            return end;
        } else {
            return start;
        }
    }

    private int numberOfPieces(int[] L, int length) {
        int pieces = 0;
        for (int i = 0; i < L.length; i++) {
            pieces += L[i] / length;
        }
        return pieces;
    }
}