package LeetCode.DFS;

import java.util.List;

public class 八皇后问题 {
    class Solution {
        List<List<String>> res;
        public List<List<String>> solveNQueens(int n) {
            for (List<String> re : res) {
                for (String s : re) {
                    s = "....";  // 初始化
                }
            }
            dfs(n);
        }

        private void dfs(int n) {
            if ()
        }
    }
}
