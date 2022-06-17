package LeetCode.DFS;


public class 岛屿数量 {
    public static void main(String[] args) {
        System.out.println(new Solution().numIslands(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        }));
    }

    static class Solution {
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public int numIslands(char[][] grid) {
            int count = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1') {
                        // 每发现一个岛屿+1
                        count++;
                        // 使用dfs将岛屿淹了
                        dfs(grid, i, j);
                    }
                }
            }
            return count;
        }

        private void dfs(char[][] grid, int i, int j) {
            int m = grid.length, n = grid[0].length;
            if (i < 0 || j < 0 || i >= m || j >= n) {
                // 超出索引边界
                return;
            }
            if (grid[i][j] == '0') {
                return;
            }

            // 进入节点
            grid[i][j] = '0';
            for (int[] dir : dirs) {
                // 遍历上下左右的节点
                dfs(grid, i + dir[0], j + dir[1]);
            }
            // 离开节点
        }
    }
}
