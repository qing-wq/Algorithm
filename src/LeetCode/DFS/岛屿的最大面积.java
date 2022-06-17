package LeetCode.DFS;

public class 岛屿的最大面积 {
    public static void main(String[] args) {
        System.out.println(new Solution().maxAreaOfIsland(new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        }));
    }
    static class Solution {
        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int max = 0,area = 0;
        public int maxAreaOfIsland(int[][] grid) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        area = 0;
                        dfs(grid, i, j);
                    }
                    max = Math.max(max, area);
                }
            }
            return max;
        }

        private void dfs(int[][] grid, int i, int j) {
            int m = grid.length, n = grid[0].length;
            if (i < 0 || j < 0 || i >= m || j >= n ) {
                return;
            }
            if (grid[i][j] == 0) {
                return;
            }
            grid[i][j] = 0;
            area++;
            for (int[] dir : dirs) {
                dfs(grid,i+dir[0],j+dir[1]);
            }
        }
    }
}
