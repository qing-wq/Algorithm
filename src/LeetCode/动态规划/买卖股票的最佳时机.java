package LeetCode.动态规划;

public class 买卖股票的最佳时机 {
    class Solution {
        public int maxProfit(int[] prices) {
            // dp[i] 表示前i个的最小值
            int[] dp = new int[prices.length];
            dp[0] = prices[0];
            int res = 0;
            for (int i = 1; i < prices.length; i++) {
                int cost = prices[i] - dp[i - 1];
                dp[i] = Math.min(dp[i - 1], prices[i]);
                if(res < cost) res = cost;
            }
            return res;
        }
    }
}
