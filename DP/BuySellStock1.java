
public class BuySellStock1 {
    
    public static void main(String[] args) {
        int[] stockPrices1 = { 8, 5, 7, 1, 9, 2, 6, 3, 5, 4, 4, 8, 15, 1, 2 };
        int[] stockPrices2 = { 5, 4, 3, 2, 1, 0 };
        int[] stockPrices3 = { 1, 2, 3, 4, 5 };

        System.out.println(maxProfit(stockPrices1));

    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1)
            return 0;

        int min = prices[0]; // min so far
        int result = 0;

        for (int i = 1; i < prices.length; i++) {
            result = Math.max(result, prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        return result;
    }

}
