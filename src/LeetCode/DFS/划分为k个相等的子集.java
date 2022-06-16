package LeetCode.DFS;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 划分为k个相等的子集 {
    public static void main(String[] args) {
        System.out.println(new Solution2().canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
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
        Map<Integer, Boolean> memo = new HashMap<>();  // 存储used已经存在过的状态
        public boolean canPartitionKSubsets(int[] nums, int k) {
            int sum = 0;
            if (nums.length < k) return false;
            for (int num : nums) {
                sum += num;
            }
            if (sum % k != 0) return false;
            int tar = sum / k;
            // 记录当前元素是否被用过
//            boolean[] used = new boolean[nums.length];
            int status = 0;  // 位图
            return dfs(nums, k, 0, status, 0, tar);
        }

        private boolean dfs(int[] nums, int k, int start, int status, int bucket, int target) {
            if (k == 0) {
                return true;
            }
            if (bucket == target) {   // 当前桶已经装满了
                boolean res = dfs(nums, k - 1, 0, status, 0, target);
                memo.put(status, res);
                return res;
            }
            if (memo.containsKey(status)) return memo.get(status);
            // 从start开始遍历后面的数是否放在桶中
            for (int i = start; i < nums.length; i++) {
                // 剪枝
                if ((status >> i & 1) == 1) continue;  // 判断第i位是否是1
                if (nums[i] + bucket > target) continue;
                // 做选择
                bucket += nums[i];
                status =  status | 1 << i;
                if (dfs(nums, k, i + 1, status, bucket, target)) {
                    return true;
                }
                // 回溯
                status = status ^ 1 << i;   // 将status第i位恢复
                bucket -= nums[i];
            }
            return false;
        }
    }
}
