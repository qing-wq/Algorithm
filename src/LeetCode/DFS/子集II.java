package LeetCode.DFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 子集II {
    public static void main(String[] args) {
        System.out.println(new Solution().subsetsWithDup(new int[]{1, 1}));
    }

    static class Solution {
        List<List<Integer>> res = new LinkedList<>();

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            LinkedList<Integer> path = new LinkedList<>();
            dfs(nums, path, 0);
            return res;
        }

        private void dfs(int[] nums, LinkedList<Integer> path, int start) {
            res.add(new LinkedList<>(path));  // 前序位置
            for (int i = start; i < nums.length; i++) {
                // 剪枝，去重
                if (i > start && nums[i] == nums[i - 1]) continue;
                path.addLast(nums[i]);
                dfs(nums, path, i + 1);
                path.removeLast();
            }
        }
    }
}