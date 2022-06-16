package LeetCode.DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 全排列 {
    public static void main(String[] args) {
        System.out.println(new Solution2().permute(new int[]{1, 2, 3}));
    }
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

    static class Solution2{
        List<List<Integer>> res = new ArrayList<>();
        boolean[] status;

        public List<List<Integer>> permute(int[] nums) {
            status = new boolean[nums.length];
            LinkedList<Integer> path = new LinkedList<>();
            dfs(nums, path);
            return res;
        }

        private void dfs(int[] nums, LinkedList<Integer> path) {
            if (path.size() == nums.length) {
                res.add(new LinkedList<>(path));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (!status[i]) {
                    path.addLast(nums[i]);
                    status[i] = true;
                    dfs(nums,path);
                    path.removeLast();
                    status[i] = false;
                }
            }
        }
    }
}
