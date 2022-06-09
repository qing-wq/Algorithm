package LeetCode.DFS;

import java.util.ArrayList;
import java.util.List;

public class 全排列 {
    class Solution {
        List<List<Integer>> list = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            List<Integer> path = new ArrayList<>();
            dfs(nums, path);
            return list;
        }


        private void dfs(int[] nums, List<Integer> path) {
            // 判断边界
            if (path.size() == nums.length) {
                list.add(new ArrayList<>(path));   // 不能直接将path加进去
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                // 判断是否满足条件
                if (path.contains(nums[i])) {
                    continue;
                }
                // 做选择
                path.add(nums[i]);
                dfs(nums, path);
                // 撤销选择
                path.remove(path.size()-1);
            }
        }
    }
}
