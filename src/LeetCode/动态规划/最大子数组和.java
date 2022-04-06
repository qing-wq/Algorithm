package LeetCode.动态规划;

public class 最大子数组和 {
    class Solution {
        public int maxSubArray(int[] nums) {
            // dp[i]的含义：包含下标i之前的最大连续子序列的和
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            int res = dp[0];  // 记录dp中的最大值
            for (int i = 1; i < nums.length; i++) {
                // 状态转移方程
                dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
                if (dp[i] > res) res = dp[i];
            }
            return res;
        }
    }
    // 时间复杂度不变，空间复杂度降低
    class Solution2 {
        public int maxSubArray(int[] nums) {
            int pre = nums[0];
            int res = pre;  // 记录dp中的最大值
            for (int i = 1; i < nums.length; i++) {
                // 状态转移方程
                pre = Math.max(pre + nums[i], nums[i]);
                if (pre > res) res = pre;
            }
            return res;
        }
    }
}
