package LeetCode.DFS;

public class 划分为k个相等的子集 {
    public static void main(String[] args) {
        System.out.println(new Solution().canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
    }

    static class Solution {
        int[] bucket;

        public boolean canPartitionKSubsets(int[] nums, int k) {
            // 记录每个桶装数字之和
            bucket = new int[k];
            dfs(nums, 0, k);
        }

        public boolean dfs(int[] nums, int index, int k) {
            if (index == nums.length) {
                for (int i = 0; i < bucket.length; i++) {
                    if (bucket[i] != k) {
                        return false;
                    }
                }
                return true;
            }
            // 穷举k个桶
            for (int i = 0; i < bucket.length; i++) {
                bucket[i] += nums[i];
                dfs(nums, index + 1, k);
                bucket[i] -= nums[i];
            }
        }
    }
}
