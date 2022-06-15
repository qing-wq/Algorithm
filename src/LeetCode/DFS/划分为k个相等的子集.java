package LeetCode.DFS;

import java.util.Arrays;

public class 划分为k个相等的子集 {
    public static void main(String[] args) {
        System.out.println(new Solution().canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 2));
    }

    // 数字视角
    static class Solution {
        int[] bucket;

        public boolean canPartitionKSubsets(int[] nums, int k) {
            Arrays.sort(nums);
            for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
                // 交换 nums[i] 和 nums[j]
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            // 记录每个桶装数字之和
            bucket = new int[k];
            if (nums.length < k) return false;
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            int target = sum / k;
            if (sum % k != 0) {
                return false;
            }
            return dfs(nums, 0, target);
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
                // 剪枝
                if ((bucket[i] + nums[index]) > k) {
                    continue;
                }
                bucket[i] += nums[index];
                if (dfs(nums, index + 1, k)) {
                    return true;
                }
                bucket[i] -= nums[index];
            }
            return false;
        }
    }

    // 桶的视角
    static class Solution2 {
        public boolean canPartitionKSubsets(int[] nums, int k) {
            int sum = 0;
            if (nums.length < k) return false;
            for (int num : nums) {
                sum += num;
            }
            if (sum % k != 0) return false;
            int tar = sum / k;
            return dfs(nums, k, 0, 0, tar);
        }

        private boolean dfs(int[] nums, int k, int index, int bucket,int target) {
            if (k > 0) {
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                // 做选择
                bucket += nums[i];
                if (dfs(nums, k, index + 1, bucket, target)) {
                    return true;
                }
                // 如果当前桶装满
                if (bucket == target) {
                    k--;
                    break;
                }
            }
        }
    }
}
