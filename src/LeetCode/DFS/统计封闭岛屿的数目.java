package LeetCode.DFS;

public class 统计封闭岛屿的数目 {
    public static void main(String[] args) {
        System.out.println(new Solution().closedIsland(new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0}
        }));
    }

    static class Solution {
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public int closedIsland(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            // 将边缘的岛屿淹掉
            for (int i = 0; i < n; i++) {
                if (grid[0][i] == 0) {
                    dfs(grid, 0, i);
                }
                if (grid[m - 1][i] == 0) {
                    dfs(grid, m - 1, i);
                }
            }
            for (int i = 0; i < m; i++) {
                if (grid[i][0] == 0) {
                    dfs(grid, i,0);
                }
                if (grid[i][n - 1] == 0) {
                    dfs(grid, i, n - 1);
                }
            }
            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) {
                        count++;
                        dfs(grid, i, j);
                    }
                }
            }
            return count;
        }

        private void dfs(int[][] grid, int i, int j) {
            int m = grid.length, n = grid[0].length;
            if (i < 0 || j < 0 || i >= m || j >= n) {
                // 超出索引边界
                return;
            }
            if (grid[i][j] == 1) {
                return;
            }

            // 进入节点
            grid[i][j] = 1;
            for (int[] dir : dirs) {
                // 遍历上下左右的节点
                dfs(grid, i + dir[0], j + dir[1]);
            }
            // 离开节点
        }
    }
}
