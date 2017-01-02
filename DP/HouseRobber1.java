
public class HouseRobber1 {

    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 2, 4, 6, 8, 0, 3 };

        System.out.println(rob(arr));
    }

    public static int rob(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;

        if (arr.length == 1)
            return arr[0];

        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < arr.length; i++) {
            dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 1]);
        }

        return dp[arr.length - 1];
    }

}
