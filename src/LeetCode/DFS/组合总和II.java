package LeetCode.DFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 组合总和II {
    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }

    static class Solution {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        int sum = 0;

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            if (candidates.length == 0) return res;
            Arrays.sort(candidates);
            dfs(candidates, target, 0);
            return res;
        }

        private void dfs(int[] nums, int target, int start) {
            if (sum == target) {
                res.add(new LinkedList<>(path));
                return;
            }
            if (sum > target) return;
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1]) continue;
                path.addLast(nums[i]);
                sum += nums[i];
                dfs(nums, target, i + 1);
                path.removeLast();
                sum -= nums[i];
            }
        }
    }
}
