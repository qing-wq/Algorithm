package LeetCode.DFS;

import sun.applet.Main;

import java.util.LinkedList;
import java.util.List;

public class 组合 {
    public static void main(String[] args) {
        System.out.println(new Solution().combine(4, 2));
    }

    static class Solution {
        List<List<Integer>> res = new LinkedList<>();
        int num;

        public List<List<Integer>> combine(int n, int k) {
            num = n;
            LinkedList<Integer> list = new LinkedList<>();
            dfs(1, k, list);
            return res;
        }

        private void dfs(int start, int k, LinkedList<Integer> list) {
            if (list.size() == k) {
                res.add(new LinkedList<>(list));
                return;
            }
            for (int i = start; i <= num; i++) {
                list.addLast(i);
                dfs(i + 1, k, list);
                list.removeLast();
            }
        }
    }
}
