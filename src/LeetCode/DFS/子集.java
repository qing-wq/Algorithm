package LeetCode.DFS;

import com.sun.xml.internal.messaging.saaj.soap.name.NameImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 子集 {
    public static void main(String[] args) {
        System.out.println(new Solution2().subsets(new int[]{1,2,3}));
    }

    static class Solution {
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            res.add(new ArrayList<>());
            dfs(nums, 0, new ArrayList<>());
            return res;
        }

        private void dfs(int[] nums, int start, List<Integer> list) {
            if (start == nums.length) return;
            for (int i = start; i < nums.length; i++) {
                list.add(nums[i]);
                res.add(new ArrayList<>(list));
                dfs(nums, i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }

    static class Solution2 {
        List<List<Integer>> res = new ArrayList<>();
        int[] num;

        public List<List<Integer>> subsets(int[] nums) {
            num = nums;
            dfs(0, 0);
            return res;
        }

        private void dfs(int u, int status) {
            if (u == num.length) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = 0; i < num.length; i++) {
                    if ((status >> i & 1) == 1) {
                        list.add(num[i]);
                    }
                }
                res.add(new ArrayList<>(list));
                return;
            }
            dfs(u + 1, status);
            dfs(u + 1, status | 1 << u);
        }
    }
}

